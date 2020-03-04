package org.sweng.realestateexplorer.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import org.sweng.realestateexplorer.data.model.LoggedInUser
import java.io.IOException


/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    private val auth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }

    fun login(email: String, password: String): Result<LoggedInUser> {
        return auth.currentUser?.let {
            Result.Error(IOException("User already signed in!"))
        } ?: createUser(email, password)
    }

    private fun getUserDetails(currentUser: FirebaseUser) =
        Result.Success(LoggedInUser(currentUser.uid, currentUser.displayName.orEmpty()))

    private fun createUser(email: String, password: String): Result<LoggedInUser> {
        return try {
            auth.createUserWithEmailAndPassword(email, password)
            getUserDetails(auth.currentUser!!)
        } catch (e: Throwable) {
            Result.Error(IOException("Error logging in.", e))
        }
    }

    fun logout() {
        auth.signOut()
    }
}

