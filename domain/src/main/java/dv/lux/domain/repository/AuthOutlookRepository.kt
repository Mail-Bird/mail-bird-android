package dv.lux.domain.repository

import dv.lux.domain.model.Token

interface AuthOutlookRepository {
    suspend fun getToken(code: String): Token

    suspend fun refreshToken(refreshToken: String): Token
}