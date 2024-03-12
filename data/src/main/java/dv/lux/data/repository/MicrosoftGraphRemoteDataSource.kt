package dv.lux.data.repository

import dv.lux.data.api.MicrosoftGraphService
import dv.lux.domain.model.User
import dv.lux.domain.repository.MicrosoftGraphRepository
import javax.inject.Inject

class MicrosoftGraphRemoteDataSource @Inject constructor(private val apiService: MicrosoftGraphService) :
    MicrosoftGraphRepository {
    override suspend fun getUser(): User {
        return apiService.getUser().toModel()
    }

    override suspend fun storeUser(user: User) {
        TODO("Not yet implemented")
    }
}