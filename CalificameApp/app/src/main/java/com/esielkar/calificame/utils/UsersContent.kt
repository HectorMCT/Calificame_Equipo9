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
        User(0, "Invitado", "", ""),
        User(1, "Hector", "hector@calificame.com", "12345678"),
        User(2, "Mayra", "mayra@calificame.com", "12345678"),
        User(3, "Esiel", "esiel_kar@hotmail.com", "12345678"),
    )

    val users get() = _users.toSet()

    var currentUser : User? = _users.elementAt(0)

    fun add(user: User) = _users.add(user)

    fun validUsername(username: String): Boolean {
        return !_users.any { it.username == username}
    }

    fun validUser(email: String, password: String): User? {
        val usr = _users.find { it.email == email }
        if (usr?.password == password)
            return usr
        return null
    }

    fun validEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}