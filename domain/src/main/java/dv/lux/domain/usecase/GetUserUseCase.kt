package dv.lux.domain.usecase

import dv.lux.domain.model.User
import dv.lux.domain.repository.MicrosoftGraphRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val microsoftGraphRepository: MicrosoftGraphRepository) :
    NonParamUseCase<User> {
    override suspend fun execute(): User {
        return microsoftGraphRepository.getUser()
    }
}