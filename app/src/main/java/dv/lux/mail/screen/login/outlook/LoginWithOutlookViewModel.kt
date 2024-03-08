package dv.lux.mail.screen.login.outlook

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dv.lux.domain.model.Token
import dv.lux.domain.usecase.GetTokenUseCase
import javax.inject.Inject

@HiltViewModel
class LoginWithOutlookViewModel @Inject constructor(
    private val getTokenUseCase: GetTokenUseCase
) : ViewModel() {

    suspend fun getToken(code: String): Token {
        return getTokenUseCase.execute(code)
    }

    fun saveToken(token: Token) {
        TODO("Not yet implemented")
    }

}