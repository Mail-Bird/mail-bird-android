package dv.lux.domain.model

data class User(
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
): BaseModel()
