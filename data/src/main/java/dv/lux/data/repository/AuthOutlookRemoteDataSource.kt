package dv.lux.data.repository

import dv.lux.data.api.AuthOutlookService
import dv.lux.domain.model.Token
import dv.lux.domain.repository.AuthOutlookRepository
import javax.inject.Inject

class AuthOutlookRemoteDataSource @Inject constructor(private val apiService: AuthOutlookService): AuthOutlookRepository {
    override suspend fun getToken(): Token? {
        throw NotImplementedError("Method is not implemented for remote data source, use local data source instead")
    }

    override suspend fun getToken(code: String): Token {
        return apiService.getToken(code = code).toModel()
    }

    override suspend fun refreshToken(refreshToken: String): Token {
        return apiService.refreshToken(refreshToken = refreshToken).toModel()
    }

    override suspend fun storeToken(token: Token) {
        throw NotImplementedError("Method is not implemented for remote data source, use local data source instead")
    }
}