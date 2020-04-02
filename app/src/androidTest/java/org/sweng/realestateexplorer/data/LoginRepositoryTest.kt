package org.sweng.realestateexplorer.data

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.firebase.auth.FirebaseAuth
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginRepositoryTest {

    private val auth = FirebaseAuth.getInstance()
    private val repo = LoginRepository(LoginDataSource(auth))

    @Before
    fun setUp() {
        auth.createUserWithEmailAndPassword("realestateapp@gmail.com", "123456789").also {
            if (it.isCanceled) throw Exception("error creating client")
        }
    }

    @After
    fun tearDown() {
        repo.logout()
    }

    @Test
    fun getUser() {
        repo.login("realestateapp@gmail.com", "123456789")
        Assert.assertTrue(repo.isLoggedIn)
        Assert.assertNotNull(repo.user)
    }

    @Test
    fun logout() {
        repo.logout()
        Assert.assertFalse(repo.isLoggedIn)
        Assert.assertNull(repo.user)
    }
}