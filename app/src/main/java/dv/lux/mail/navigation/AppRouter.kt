package dv.lux.mail.navigation

interface AppRouter {
    fun showLogin()
    fun showHome()
    fun back()
    fun navigationUp(): Boolean
}
