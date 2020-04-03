package org.sweng.realestateexplorer.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.google.firebase.auth.FirebaseAuth
import org.sweng.realestateexplorer.data.UserLoginResult.LoginStatus.*

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

class LoginRepository(private val auth: FirebaseAuth = FirebaseAuth.getInstance()) {

    private val _userLoginResult = MutableLiveData(UserLoginResult())
    val user: LiveData<LoggedInUser> = Transformations.map(_userLoginResult) {
        it.loggedInUser
    }

    fun logout() {
        auth.signOut()
        _userLoginResult.postValue(UserLoginResult(null, SIGNED_OUT))
    }

    fun login(username: String, password: String): LiveData<UserLoginResult> {

        auth.currentUser?.let {
            _userLoginResult.value =
                UserLoginResult(LoggedInUser(it.uid, it.displayName ?: ""), LOGGED_IN)
            return@login _userLoginResult
        }

        auth.signInWithEmailAndPassword(username, password).addOnSuccessListener {
            auth.currentUser!!.let {
                _userLoginResult.value =
                    UserLoginResult(LoggedInUser(it.uid, it.displayName ?: ""), LOGGED_IN)
            }
        }.addOnFailureListener {
            auth.createUserWithEmailAndPassword(username, password)
                .addOnSuccessListener {
                    auth.currentUser!!.let {
                        _userLoginResult.value =
                            UserLoginResult(LoggedInUser(it.uid, it.displayName ?: ""), LOGGED_IN)
                    }
                }.addOnFailureListener {
                    _userLoginResult.value = UserLoginResult(null, FAILED)
                }
        }

        return _userLoginResult
    }
}
