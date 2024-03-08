package dv.lux.data.api

import dv.lux.data.BuildConfig
import dv.lux.data.model.vo.TokenVO
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthOutlookService {
    @POST("/common/oauth2/v2.0/token")
    @FormUrlEncoded
    suspend fun getToken(
        @Field("client_id") clientId: String = BuildConfig.OUTLOOK_CLIENT_ID,
        @Field("code") code: String,
        @Field("redirect_uri") redirectUri: String = BuildConfig.OUTLOOK_REDIRECT_URI,
        @Field("scope") scope: String = BuildConfig.OUTLOOK_SCOPE,
        @Field("grant_type") grantType: String = "authorization_code",
    ): TokenVO

    @POST("/common/oauth2/v2.0/token")
    @FormUrlEncoded
    suspend fun refreshToken(
        @Field("client_id") clientId: String = BuildConfig.OUTLOOK_CLIENT_ID,
        @Field("refresh_token") refreshToken: String,
        @Field("redirect_uri") redirectUri: String = BuildConfig.OUTLOOK_REDIRECT_URI,
        @Field("scope") scope: String = BuildConfig.OUTLOOK_SCOPE,
        @Field("grant_type") grantType: String = "refresh_token",
    ): TokenVO

}