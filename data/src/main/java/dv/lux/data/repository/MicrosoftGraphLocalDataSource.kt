package dv.lux.data.repository

import dv.lux.domain.model.User
import dv.lux.domain.repository.MicrosoftGraphRepository
import dv.lux.utilities.preference.SecureStoragePreference
import javax.inject.Inject

class MicrosoftGraphLocalDataSource @Inject constructor(private val secureStoragePreference: SecureStoragePreference) :
    MicrosoftGraphRepository {
    override suspend fun getUser(): User? {
        TODO("Not yet implemented")
    }

    override suspend fun storeUser(user: User) {
        TODO("Not yet implemented")
    }
}