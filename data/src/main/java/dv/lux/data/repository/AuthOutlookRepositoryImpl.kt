package dv.lux.data.repository

import dv.lux.data.api.AuthOutlookService
import dv.lux.domain.model.Token
import dv.lux.domain.repository.AuthOutlookRepository
import javax.inject.Inject

class AuthOutlookRepositoryImpl @Inject constructor(private val apiService: AuthOutlookService) :
    AuthOutlookRepository {
    override suspend fun getToken(code: String): Token {
        return apiService.getToken(
            code = code,
        ).toModel()
    }

    override suspend fun refreshToken(refreshToken: String): Token {
        return apiService.refreshToken(
            refreshToken = refreshToken,
        ).toModel()
    }

}