package dv.lux.data.repository

import dv.lux.domain.constant.StorageKey
import dv.lux.domain.model.Token
import dv.lux.domain.repository.AuthOutlookRepository
import dv.lux.utilities.preference.SecureStoragePreference
import javax.inject.Inject

class AuthOutlookLocalDataSource @Inject constructor(private val secureStoragePreference: SecureStoragePreference) :
    AuthOutlookRepository {
    override suspend fun getToken(): Token? {
        return secureStoragePreference.getObject(key = StorageKey.TOKEN, clazz = Token::class.java)
    }

    override suspend fun getToken(code: String): Token {
        throw NotImplementedError("Method is not implemented for local data source, use remote data source instead")
    }

    override suspend fun refreshToken(refreshToken: String): Token {
        throw NotImplementedError("Method is not implemented for local data source, use remote data source instead")
    }

    override suspend fun storeToken(token: Token) {
        secureStoragePreference.saveObject(key = StorageKey.TOKEN, value = token)
    }
}