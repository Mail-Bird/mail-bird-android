package dv.lux.mail.navigation

abstract class AppRoutes(baseRoute: String) {
    open val route: String = baseRoute
}

object LoginGraphRoute : AppRoutes("LoginGraph")
object LoginScreenRoute : AppRoutes("Login")
object HomeGraphRoute : AppRoutes("HomeGraph")
object HomeScreenRoute : AppRoutes("Home")