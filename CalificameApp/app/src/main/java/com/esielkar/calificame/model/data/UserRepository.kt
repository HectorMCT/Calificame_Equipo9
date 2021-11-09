package com.esielkar.calificame.model.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import com.esielkar.calificame.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class UserRepository {
    private val auth : FirebaseAuth = Firebase.auth

    private val fUser = MutableLiveData<FirebaseUser?>()
    val user : LiveData<User?>
        get() {
            return fUser.map {
                it?.let {
                    User(it.displayName!!, it.email!!)
                }
            }
        }

    private val _fError = MutableLiveData<String?>()
    val fError : LiveData<String?>
        get() = _fError

    fun signUp(username : String, email : String, password : String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    auth.currentUser?.updateProfile(
                        UserProfileChangeRequest.Builder()
                            .setDisplayName(username).build()
                    )?.addOnCompleteListener {
                        if (it.isSuccessful) {
                            fUser.postValue(auth.currentUser)
                        }
                    }?.addOnFailureListener {
                        _fError.postValue(it.message)
                    }
                }
            }
    }

    fun signIn(email : String, password : String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    fUser.postValue(auth.currentUser)
                }
            }.addOnFailureListener {
                _fError.postValue(it.message)
            }
    }

    fun signOut() {
        auth.signOut()
    }
}