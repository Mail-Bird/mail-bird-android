package dv.lux.data.model.vo

import com.google.gson.annotations.SerializedName
import dv.lux.domain.model.User

data class UserVO(
    @SerializedName("user_principal_name") val userPrincipalName: String,
    @SerializedName("id") val id: String,
    @SerializedName("display_name") val displayName: String,
    @SerializedName("surname") val surname: String,
    @SerializedName("given_name") val givenName: String,
    @SerializedName("preferred_language") val preferredLanguage: String,
    @SerializedName("mail") val mail: String,
    @SerializedName("mobile_phone") val mobilePhone: String?,
    @SerializedName("job_title") val jobTitle: String?,
    @SerializedName("office_location") val officeLocation: String?,
    @SerializedName("business_phones") val businessPhones: List<String>,
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