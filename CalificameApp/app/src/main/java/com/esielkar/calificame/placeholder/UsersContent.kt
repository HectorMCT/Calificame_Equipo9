package com.esielkar.calificame.placeholder

import com.esielkar.calificame.model.User

object UsersContent {
    private val _users = mutableSetOf<User>(
        User("Invitado", "", ""),
        User("Hector", "hector@calificame.com", "12345678"),
        User("Mayra", "mayra@calificame.com", "12345678"),
        User("Esiel", "esiel_kar@hotmail.com", "12345678"),
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