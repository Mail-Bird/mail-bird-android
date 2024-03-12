package dv.lux.data.repository

import dv.lux.domain.inject.LocalDataSource
import dv.lux.domain.inject.RemoteDataSource
import dv.lux.domain.model.Token
import dv.lux.domain.repository.AuthOutlookRepository
import javax.inject.Inject

class AuthOutlookRepositoryImpl @Inject constructor(
    @LocalDataSource private val localDataSource: AuthOutlookRepository,
    @RemoteDataSource private val remoteDataSource: AuthOutlookRepository
) :
    AuthOutlookRepository {
    override suspend fun getToken(): Token? {
        return localDataSource.getToken()
    }

    override suspend fun getToken(code: String): Token {
        return remoteDataSource.getToken(
            code = code,
        )
    }

    override suspend fun refreshToken(refreshToken: String): Token {
        return remoteDataSource.refreshToken(
            refreshToken = refreshToken,
        )
    }

    override suspend fun storeToken(token: Token) {
        localDataSource.storeToken(token)
    }

}