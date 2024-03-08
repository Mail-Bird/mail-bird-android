package dv.lux.domain.repository

import dv.lux.domain.model.User

interface MicrosoftGraphRepository {
    suspend fun getUser(): User

}