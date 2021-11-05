package com.esielkar.calificame.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.esielkar.calificame.R
import com.esielkar.calificame.model.User
import com.esielkar.calificame.model.data.UserRepository
import com.esielkar.calificame.utils.UsersContent

class UserViewModel(
    private val userRepository : UserRepository
) : ViewModel() {

    val username = MutableLiveData("")
    val email = MutableLiveData("")
    val password = MutableLiveData("")

    private val _warning = MutableLiveData<Int>()
    val warning: LiveData<Int?>
        get() = _warning

    private val _error = MutableLiveData<Int>()
    val error: LiveData<Int?>
        get() = _error

    val fError: LiveData<String?>
        get() = userRepository.fError

    val user : LiveData<User?>
        get() = userRepository.user

    fun signUp() {
        when {
            username.value!!.isNotBlank() && password.value!!.isNotBlank() && email.value!!.isNotBlank() -> {
                var vEmail = UsersContent.validEmail(email.value!!)

                if(vEmail) {
                    userRepository.signUp(username.value!!, email.value!!, password.value!!)
                    UsersContent.currentUser = userRepository.user.value
                }else{
                    _error.value = R.string.error_email
                    //_error.value = R.string.error_signup
                }
            }
            else -> {
                if (email.value!!.isBlank()) _warning.value = R.string.error_noEmail
                else if (username.value!!.isBlank()) _warning.value = R.string.error_noUsername
                else if (password.value!!.isBlank()) _warning.value = R.string.error_noPassword
            }
        }

    }

    fun signIn() {
        when {
            password.value!!.isNotBlank() && email.value!!.isNotBlank() -> {
                val vEmail = UsersContent.validEmail(email.value!!)
                if(vEmail) {
                    userRepository.signIn(email.value!!, password.value!!)
                } else {
                    _error.value = R.string.error_email
                    //_error.value = R.string.error_login
                }
            } else -> {
                if (email.value!!.isBlank())
                    _warning.value = R.string.error_noEmail
                else if (password.value!!.isBlank())
                    _warning.value = R.string.error_noPassword
            }
        }
    }

    fun signOut() {
        userRepository.signOut()
    }
}