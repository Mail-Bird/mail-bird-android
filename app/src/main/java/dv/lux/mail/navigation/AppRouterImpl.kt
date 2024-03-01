package dv.lux.mail.navigation

import androidx.navigation.NavHostController

class AppRouterImpl(
    private val navigationController: NavHostController
) : AppRouter {

    override fun showTermsOfUse() {
        navigationController.navigate(TermsOfUseScreenRoute.route)
    }

    override fun showLogin() {
        navigationController.navigate(LoginScreenRoute.route) {
            popUpTo(0) // reset stack
        }
    }

    override fun showHome() {
        navigationController.navigate(HomeScreenRoute.route) {
            popUpTo(LoginGraphRoute.route) {
                inclusive = true
                saveState = false
            }
        }
    }
    override fun back() {
        navigationController.popBackStack()
    }

    override fun navigationUp(): Boolean {
        return navigationController.navigateUp()
    }
}