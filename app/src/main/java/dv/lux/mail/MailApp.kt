package dv.lux.mail

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dv.lux.mail.component.ChromeBrowserTab
import dv.lux.mail.screen.NavigationRoutes
import dv.lux.mail.screen.home.HomeScreen
import dv.lux.mail.screen.profile.ProfileScreen
import dv.lux.mail.ui.theme.MailTheme

@Composable
fun MailApp(
    navController: NavHostController = rememberNavController()
) {
    MailTheme(darkTheme = false, dynamicColor = false) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            NavHost(
                navController = navController,
                startDestination = NavigationRoutes.Home.name,
                enterTransition = { fadeIn(animationSpec = tween(300)) },
                exitTransition = { fadeOut(animationSpec = tween(300)) },
            ) {
                composable(route = NavigationRoutes.Home.name) {
                    HomeScreen(
                        onOpenSearch = {
                            navController.navigate(NavigationRoutes.Search.name)
                        },
                        onOpenProfile = {
                            navController.navigate(NavigationRoutes.Profile.name)
                    },)
                }
                composable(route = NavigationRoutes.Profile.name) {
                    ProfileScreen(onBackPress = {
                        navController.popBackStack()
                    })
                }
                composable(route = NavigationRoutes.Search.name) {
                    ChromeBrowserTab()
                }
            }
        }
    }
}