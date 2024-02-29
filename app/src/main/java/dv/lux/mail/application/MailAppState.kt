package dv.lux.mail.application

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dv.lux.mail.navigation.AppRouter
import dv.lux.mail.navigation.AppRouterImpl

@Composable
fun rememberMailAppState(
    navController: NavHostController = rememberNavController()
): MailAppState {
    return remember(navController) {
        MailAppState(AppRouterImpl(navController), navController)
    }
}

@Stable
data class MailAppState(
    val router: AppRouter,
    internal val navHostController: NavHostController,
)