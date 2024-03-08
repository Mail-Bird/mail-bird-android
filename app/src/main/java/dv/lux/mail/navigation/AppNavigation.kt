package dv.lux.mail.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import dv.lux.mail.application.MailAppState
import dv.lux.mail.screen.WebViewScreen
import dv.lux.mail.screen.home.HomeScreen
import dv.lux.mail.screen.home.HomeViewModel
import dv.lux.mail.screen.login.LoginScreen
import dv.lux.mail.screen.login.LoginViewModel
import dv.lux.mail.screen.login.outlook.LoginWithOutlookScreen
import dv.lux.mail.screen.login.outlook.LoginWithOutlookViewModel

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
        globalGraph(appState.router)
    }
}

fun NavGraphBuilder.globalGraph(router: AppRouter) {
    navigation(
        route = GlobalGraphRoute.route,
        startDestination = TermsOfUseScreenRoute.route
    ) {
        composable(route = TermsOfUseScreenRoute.route) {
            WebViewScreen("https://alia.geekup.vn/privacy-policy")
        }
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
            LoginScreen(
                onClickTermsOfUse = router::showTermsOfUse,
                onClickLoginWithOutlook = router::onClickLoginWithOutlook
            )
        }
        composable(route = LoginWithOutlookScreenRoute.route) {
            val viewModel = hiltViewModel<LoginWithOutlookViewModel>()
            LoginWithOutlookScreen(viewModel)
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