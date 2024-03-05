package dv.lux.mail.navigation

abstract class AppRoutes(baseRoute: String) {
    open val route: String = baseRoute
}

object GlobalGraphRoute : AppRoutes("GlobalGraph")
object TermsOfUseScreenRoute : AppRoutes("TermsOfUse")

object LoginGraphRoute : AppRoutes("LoginGraph")
object LoginScreenRoute : AppRoutes("Login")
object LoginWithOutlookScreenRoute : AppRoutes("LoginWithOutlook")

object HomeGraphRoute : AppRoutes("HomeGraph")
object HomeScreenRoute : AppRoutes("Home")