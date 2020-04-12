package org.sweng.realestateexplorer.data.login

data class UserLoginResult(
    var loggedInUser: LoggedInUser? = null,
    var status: LoginStatus = LoginStatus.WAITING
) {
    enum class LoginStatus { LOGGED_IN, WAITING, FAILED, SIGNED_OUT }
}