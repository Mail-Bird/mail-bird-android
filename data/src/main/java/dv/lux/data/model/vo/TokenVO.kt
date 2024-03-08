package dv.lux.data.model.vo

import com.google.gson.annotations.SerializedName
import dv.lux.domain.model.Token

data class TokenVO(
    @SerializedName("token_type") val tokenType: String,
    @SerializedName("scope") val scope: String,
    @SerializedName("expires_in") val expiresIn: Int,
    @SerializedName("ext_expires_in") val extExpiresIn: Int,
    @SerializedName("access_token") val accessToken: String,
    @SerializedName("refresh_token") val refreshToken: String,
    @SerializedName("id_token") val idToken: String
): BaseVO<Token>() {
    override fun toModel(): Token {
        return Token(
            tokenType = tokenType,
            scope = scope,
            expiresIn = expiresIn,
            extExpiresIn = extExpiresIn,
            accessToken = accessToken,
            refreshToken = refreshToken,
            idToken = idToken
        )
    }

}