package dv.lux.mail.navigation

interface AppRouter {
    fun showTermsOfUse()
    fun showLogin()
    fun onClickLoginWithOutlook()
    fun showHome()
    fun back()
    fun navigationUp(): Boolean
}
