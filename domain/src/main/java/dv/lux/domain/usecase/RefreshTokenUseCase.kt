package dv.lux.domain.usecase

import dv.lux.domain.inject.Repository
import dv.lux.domain.model.Token
import dv.lux.domain.repository.AuthOutlookRepository
import javax.inject.Inject

class RefreshTokenUseCase @Inject constructor(@Repository private val authOutlookRepository: AuthOutlookRepository) : UseCase<String, Token> {
    override suspend fun execute(refreshToken: String): Token {
        return authOutlookRepository.refreshToken(refreshToken)
    }
}