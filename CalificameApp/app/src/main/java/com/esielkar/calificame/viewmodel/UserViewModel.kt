package com.esielkar.calificame.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esielkar.calificame.R
import com.esielkar.calificame.model.User
import com.esielkar.calificame.model.data.UserRepository
import com.esielkar.calificame.utils.UsersContent
import kotlinx.coroutines.launch

class UserViewModel(
    private val userRepository : UserRepository
) : ViewModel() {

    val username = MutableLiveData("")
    val email = MutableLiveData("")
    val password = MutableLiveData("")

    private val _error = MutableLiveData<Int>()
    val error: LiveData<Int?>
        get() = _error

    private val _user = MutableLiveData<User>()
    val user : LiveData<User?>
        get() = _user

    fun signup() {
        viewModelScope.launch {
            signup(username.value!!, email.value!!, password.value!!)
        }

    }

    fun signin() {
        viewModelScope.launch {
            signin(email.value!!, password.value!!)
        }
    }

    fun prepopulate() {
        val users = listOf(
            User(username = "Invitado", email = "", password = ""),
            User(username = "Esiel", email = "esiel_kar@hotmail.com", password = "12345678"),
            User(username = "Hector", email = "hector@calificame.com", password = "12345678"),
            User(username = "Mayra", email = "mayra@calificame.com", password = "12345678")
        )

        viewModelScope.launch {
            Log.d("BASEDEDATOS", "REPOSITORY CALL")
            userRepository.populateUsers(users)
        }
    }

    private suspend fun signin(email: String, password: String) {
        when {
            password.isNotBlank() && email.isNotBlank() -> {
                val vEmail = UsersContent.validEmail(email)

                val vUser = userRepository.login(email, password)
                if(vEmail && vUser != null) {
                    _user.value = vUser!!
                }else{
                    if(vUser == null) _error.value = R.string.error_password
                    else if (!vEmail) _error.value = R.string.error_email
                    else _error.value = R.string.error_login
                }
            }else -> {
                if (email.isBlank())
                    _error.value = R.string.error_noEmail
                else if (password.isBlank())
                    _error.value = R.string.error_noPassword
            }
        }
    }

    private suspend fun signup(username: String, email: String, password: String) {
        when {
            username.isNotBlank() && password.isNotBlank() && email.isNotBlank() -> {
                var vEmail = UsersContent.validEmail(email)
                val vUser = userRepository.findUser(email)

                if(vEmail && vUser == null) {
                    userRepository.signup(User(
                        username = username,
                        email = email,
                        password = password)
                    )
                    UsersContent.currentUser = userRepository.login(email, password)
                    /*preferences.edit()
                        .putString(UsersContent.SP_EMAIL, email)
                        .putString(UsersContent.SP_PASSWORD, password)
                        .putBoolean(UsersContent.SP_IS_LOGGED, true)
                        .apply()
                    return true*/
                }else{
                    if(vUser == null) _error.value = R.string.error_username
                    else if (!vEmail) _error.value = R.string.error_email
                    else _error.value = R.string.error_signup
                }
            }
            else -> {
                if (email.isBlank()) _error.value = R.string.error_noEmail
                else if (username.isBlank()) _error.value = R.string.error_noUsername
                else if (password.isBlank()) _error.value = R.string.error_noPassword
            }
        }
    }



}