package dv.lux.domain.model

data class Token(
    val tokenType: String,
    val scope: String,
    val expiresIn: Int,
    val extExpiresIn: Int,
    val accessToken: String,
    val refreshToken: String,
    val idToken: String
): BaseModel()