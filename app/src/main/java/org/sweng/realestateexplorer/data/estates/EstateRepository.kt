package org.sweng.realestateexplorer.data.estates

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.firestore.ktx.toObjects
import com.google.firebase.ktx.Firebase
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class EstateRepository {

    private val db by lazy { Firebase.firestore.collection("estates") }

    suspend fun getEstate(id: String): Estate {
        return suspendCoroutine { cont ->
            db.document(id).get().addOnSuccessListener {
                cont.resume(it.toObject()!!)
            }.addOnFailureListener {
                cont.resumeWithException(it)
            }
        }
    }

    suspend fun getEstates(): List<Estate> {
        return suspendCoroutine { cont ->
            db.get().addOnSuccessListener {
                    cont.resume(it.toObjects())
                }
                .addOnFailureListener {
                    cont.resumeWithException(it)
                }
        }
    }
}