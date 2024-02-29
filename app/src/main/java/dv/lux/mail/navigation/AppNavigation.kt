package dv.lux.mail.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import dv.lux.mail.application.MailAppState
import dv.lux.mail.screen.home.HomeScreen
import dv.lux.mail.screen.home.HomeViewModel
import dv.lux.mail.screen.login.LoginScreen
import dv.lux.mail.screen.login.LoginViewModel

@Composable
fun AppNavigation(
    appState: MailAppState,
    isLoggedIn: Boolean,
) {
    val initialRoute = if (isLoggedIn) HomeGraphRoute.route else LoginGraphRoute.route

    NavHost(
        navController = appState.navHostController,
        startDestination = initialRoute
    ) {
        loginGraph(appState.router)
        homesGraph(appState.router)
    }
}
fun NavGraphBuilder.loginGraph(
    router: AppRouter
) {
    navigation(
        route = LoginGraphRoute.route,
        startDestination = LoginScreenRoute.route
    ) {
        composable(route = LoginScreenRoute.route) {
            val viewModel = hiltViewModel<LoginViewModel>()
            LoginScreen()
        }
    }
}

fun NavGraphBuilder.homesGraph(
    router: AppRouter
) {
    navigation(
        route = HomeGraphRoute.route,
        startDestination = HomeScreenRoute.route
    ) {
        composable(HomeScreenRoute.route) {
            val viewModel = hiltViewModel<HomeViewModel>()
            HomeScreen()
        }
    }
}