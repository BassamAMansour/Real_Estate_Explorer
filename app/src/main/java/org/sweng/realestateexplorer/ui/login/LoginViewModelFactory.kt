package org.sweng.realestateexplorer.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.sweng.realestateexplorer.data.login.LoginRepository

/**
 * ViewModel provider factory to instantiate LoginViewModel.
 * Required given LoginViewModel has a non-empty constructor
 */
class LoginViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(LoginRepository()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
