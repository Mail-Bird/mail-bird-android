package dv.lux.domain.usecase

import dv.lux.domain.model.Token
import dv.lux.domain.repository.AuthOutlookRepository
import javax.inject.Inject

class GetTokenUseCase @Inject constructor(private val authOutlookRepository: AuthOutlookRepository) :
    UseCase<String, Token> {
    override suspend fun execute(code: String): Token {
        return authOutlookRepository.getToken(code)
    }
}