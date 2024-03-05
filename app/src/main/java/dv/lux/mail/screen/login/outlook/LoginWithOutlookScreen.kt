package dv.lux.mail.screen.login.outlook

import android.annotation.SuppressLint
import android.text.TextUtils
import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun LoginWithOutlookScreen() {

    AndroidView(
        factory = { context ->
            WebView(context).apply {
                settings.javaScriptEnabled = true
                this.webViewClient = CustomWebViewClient()

                settings.loadWithOverviewMode = true
                settings.useWideViewPort = true
                settings.setSupportZoom(true)
            }
        },
        update = { webView ->
            val clientId = "09332e54-c687-4dc3-a28c-c225306846fd"
            val redirectUri = "mailbrid://login-success"
            val scope = "openid profile offline_access https://graph.microsoft.com/mail.send https://graph.microsoft.com/mail.readwrite https://graph.microsoft.com/contacts.read https://graph.microsoft.com/calendars.readwrite https://graph.microsoft.com/User.Read"
            val state = "3d41745f-3959-483f-a151-8d78fe384428"
            webView.loadUrl("https://login.live.com/oauth20_authorize.srf?response_type=code&response_mode=query&prompt=login&client_id=$clientId&redirect_uri=$redirectUri&scope=$scope&state=$state")
        },
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
    )
}

class CustomWebViewClient: WebViewClient(){

    val clientId = "09332e54-c687-4dc3-a28c-c225306846fd"
    val redirectUri = "mailbrid://login-success"
    val scope = "openid profile offline_access https://graph.microsoft.com/mail.send https://graph.microsoft.com/mail.readwrite https://graph.microsoft.com/contacts.read https://graph.microsoft.com/calendars.readwrite https://graph.microsoft.com/User.Read"
    val state = "3d41745f-3959-483f-a151-8d78fe384428"
    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        // TODO loading

        if (request?.url?.toString()?.startsWith(redirectUri) == false) {
            return super.shouldOverrideUrlLoading(view, request)
        }

        if (state != request?.url?.getQueryParameter("state")) {
            // TODO show error
            // TODO cancel loading
            return false
        }

        val error = request.url?.getQueryParameter("error")
        if (TextUtils.isEmpty(error)) {
            val code = request.url?.getQueryParameter("code")
            if (!TextUtils.isEmpty(code)) {
                // TODO Handle get toke from code
                Log.e("TAG", "shouldOverrideUrlLoading: $code")
                return true
            }
            // TODO show error
        } else if ("access_denied" != error) {
            // TODO show error
        }

        // TODO cancel loading
        return false
    }
}