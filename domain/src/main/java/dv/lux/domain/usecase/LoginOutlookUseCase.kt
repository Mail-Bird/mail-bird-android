package dv.lux.domain.usecase

import dv.lux.domain.inject.Repository
import dv.lux.domain.model.Token
import dv.lux.domain.repository.AuthOutlookRepository
import dv.lux.domain.repository.MicrosoftGraphRepository
import javax.inject.Inject

class LoginOutlookUseCase @Inject constructor(
    @Repository private val authOutlookRepository: AuthOutlookRepository,
    @Repository private val microsoftGraphRepository: MicrosoftGraphRepository
) :
    UseCase<String, Token> {
    override suspend fun execute(code: String): Token {
        val token = authOutlookRepository.getToken(code)
        authOutlookRepository.storeToken(token)
        microsoftGraphRepository.getUser()
        return token
    }
}