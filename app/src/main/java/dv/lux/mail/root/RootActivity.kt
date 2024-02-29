package dv.lux.mail.root

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import dv.lux.mail.application.rememberMailAppState
import dv.lux.mail.navigation.AppRouter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RootActivity : ComponentActivity() {

    private val rootViewModel: RootViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(rootViewModel)
        setContent {
            val appState = rememberMailAppState()
            MailApp(
                appState = appState,
                isLoggedIn = rootViewModel.isLoggedIn.value ?: false
            )
            LaunchedEffect(this@RootActivity) {
                launchLoginObserver(appState.router)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(rootViewModel)
    }

    private fun launchLoginObserver(router: AppRouter) {
        lifecycleScope.launch(Dispatchers.Main) {
            rootViewModel.isLoggedIn.collect { isLoggedInState ->
                if (isLoggedInState == false) {
                    router.showLogin()
                } else {
//                    router.showHome()
                }
            }
        }
    }
}