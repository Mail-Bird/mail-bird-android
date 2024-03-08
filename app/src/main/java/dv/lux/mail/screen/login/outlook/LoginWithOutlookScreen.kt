package dv.lux.mail.screen.login.outlook

import android.annotation.SuppressLint
import android.text.TextUtils
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import dv.lux.data.BuildConfig
import dv.lux.domain.model.Token
import kotlinx.coroutines.launch

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun LoginWithOutlookScreen(viewModel: LoginWithOutlookViewModel) {

    val loginOutlookEndpoint =
        "https://login.live.com/oauth20_authorize.srf?response_type=code&response_mode=query&prompt=login&client_id=${
            BuildConfig
                .OUTLOOK_CLIENT_ID
        }&redirect_uri=${BuildConfig.OUTLOOK_REDIRECT_URI}&scope=${BuildConfig.OUTLOOK_SCOPE}&state=${BuildConfig.OUTLOOK_STATE}"

    val scope = rememberCoroutineScope()

    AndroidView(
        factory = { context ->
            WebView(context).apply {
                settings.javaScriptEnabled = true
                this.webViewClient = CustomWebViewClient(handleGetToken = { code ->
                    scope.launch {
                        val token: Token = viewModel.getToken(code)
                        if (!TextUtils.isEmpty(token.idToken)) {
                            viewModel.saveToken(token)
                        }
                    }
                })

                settings.loadWithOverviewMode = true
                settings.useWideViewPort = true
                settings.setSupportZoom(true)
            }
        },
        update = { webView ->
            webView.loadUrl(loginOutlookEndpoint)
        },
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
    )
}

class CustomWebViewClient(
    private val handleGetToken: (code: String) -> Unit
) : WebViewClient() {

    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        if (request?.url?.toString()?.startsWith(BuildConfig.OUTLOOK_REDIRECT_URI) == false) {
            return super.shouldOverrideUrlLoading(view, request)
        }

        if (BuildConfig.OUTLOOK_STATE != request?.url?.getQueryParameter("state")) {
            // TODO show error
            return false
        }

        val error = request.url?.getQueryParameter("error")
        if (TextUtils.isEmpty(error)) {
            val code = request.url?.getQueryParameter("code")
            if (!TextUtils.isEmpty(code)) {
                handleGetToken.invoke(code ?: "")
                return true
            }
            // TODO show error
        } else if ("access_denied" != error) {
            // TODO show error
        }
        return false
    }
}