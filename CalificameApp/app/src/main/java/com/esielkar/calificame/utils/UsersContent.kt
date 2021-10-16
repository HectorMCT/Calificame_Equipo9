package com.esielkar.calificame.utils

import com.esielkar.calificame.model.User

/**
 * TODO ESTO ES PROVICIONAL Y SE ELIMINARA CUANDO SE OCUPE LA PERSISTENCIA DE DATOS
 */

object UsersContent {

    const val SP_IS_LOGGED = "isLogged"
    const val SP_EMAIL = "email"
    const val SP_PASSWORD = "password"
    const val SP_IMAGE = "profile_image"

    private val _users = mutableSetOf<User>(
        User("Invitado", "")
    )

    val users get() = _users.toSet()

    var currentUser : User? = users.elementAt(0)


    fun validUsername(username: String): Boolean {
        return !_users.any { it.username == username}
    }

    fun validUser(email: String, password: String): User? {
        return _users.find { it.email == email }
    }

    fun validEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}