package dv.lux.mail.root

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dv.lux.mail.application.MailAppState
import dv.lux.mail.navigation.AppNavigation
import dv.lux.mail.ui.theme.MailTheme

@Composable
fun MailApp(
    appState: MailAppState,
    isLoggedIn: Boolean,
) {
    MailTheme(darkTheme = false, dynamicColor = false) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            AppNavigation(
                appState = appState,
                isLoggedIn = isLoggedIn
            )
        }
    }
}