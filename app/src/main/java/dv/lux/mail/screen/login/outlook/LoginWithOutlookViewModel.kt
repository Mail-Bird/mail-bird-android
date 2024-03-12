package dv.lux.mail.screen.login.outlook

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dv.lux.domain.model.Token
import dv.lux.domain.usecase.LoginOutlookUseCase
import javax.inject.Inject

@HiltViewModel
class LoginWithOutlookViewModel @Inject constructor(
    private val loginOutlookUseCase: LoginOutlookUseCase
) : ViewModel() {

    suspend fun getToken(code: String): Token {
        return loginOutlookUseCase.execute(code)
    }

    fun saveToken(token: Token) {

    }

}