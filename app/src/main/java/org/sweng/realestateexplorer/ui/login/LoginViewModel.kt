package org.sweng.realestateexplorer.ui.login

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import org.sweng.realestateexplorer.R
import org.sweng.realestateexplorer.data.login.LoginRepository
import org.sweng.realestateexplorer.data.login.UserLoginResult
import org.sweng.realestateexplorer.data.login.UserLoginResult.LoginStatus.FAILED
import org.sweng.realestateexplorer.data.login.UserLoginResult.LoginStatus.LOGGED_IN

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val _loginFormState = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginFormState

    private var userLoginResult = MutableLiveData<UserLoginResult>()

    val loginResult: LiveData<LoginResult> = Transformations.map(userLoginResult) {
        when (it.status) {
            LOGGED_IN -> LoginResult(LoggedInUserView(it.loggedInUser!!.displayName))
            FAILED -> LoginResult(error = R.string.login_failed)
            else -> null
        }
    }

    fun login(username: String, password: String) {
        loginRepository.login(username, password).observeForever { userLoginResult.value = it }
    }

    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
            _loginFormState.value = LoginFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            _loginFormState.value = LoginFormState(passwordError = R.string.invalid_password)
        } else {
            _loginFormState.value = LoginFormState(isDataValid = true)
        }
    }

    private fun isUserNameValid(username: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(username).matches()

    private fun isPasswordValid(password: String): Boolean = password.length > 5
}
