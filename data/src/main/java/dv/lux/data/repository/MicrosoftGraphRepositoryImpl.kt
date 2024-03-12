package dv.lux.data.repository

import dv.lux.domain.inject.LocalDataSource
import dv.lux.domain.inject.RemoteDataSource
import dv.lux.domain.model.User
import dv.lux.domain.repository.MicrosoftGraphRepository
import javax.inject.Inject

class MicrosoftGraphRepositoryImpl @Inject constructor(
    @LocalDataSource private val localDataSource: MicrosoftGraphRepository,
    @RemoteDataSource private val remoteDataSource: MicrosoftGraphRepository
) :
    MicrosoftGraphRepository {
    override suspend fun getUser(): User? {
        return remoteDataSource.getUser()
    }

    override suspend fun storeUser(user: User) {
        localDataSource.storeUser(user)
    }
}