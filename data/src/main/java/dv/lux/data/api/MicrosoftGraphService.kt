package dv.lux.data.api

import dv.lux.data.model.vo.UserVO
import retrofit2.http.GET

interface MicrosoftGraphService {

    @GET("/v1.0/me")
    suspend fun getUser(): UserVO
}