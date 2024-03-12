package dv.lux.data.model.vo

import dv.lux.domain.model.User

data class UserVO(
    val userPrincipalName: String,
    val id: String,
    val displayName: String,
    val surname: String,
    val givenName: String,
    val preferredLanguage: String,
    val mail: String,
    val mobilePhone: String?,
    val jobTitle: String?,
    val officeLocation: String?,
    val businessPhones: List<String>,
) : BaseVO<User>() {
    override fun toModel(): User {
        return User(
            userPrincipalName = userPrincipalName,
            id = id,
            displayName = displayName,
            surname = surname,
            givenName = givenName,
            preferredLanguage = preferredLanguage,
            mail = mail,
            mobilePhone = mobilePhone,
            jobTitle = jobTitle,
            officeLocation = officeLocation,
            businessPhones = businessPhones
        )
    }

}