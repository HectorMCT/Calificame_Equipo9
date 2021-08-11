package com.esielkar.calificame.placeholder

import com.esielkar.calificame.model.User

object UsersContent {
    private val users = mutableSetOf<User>(
        User("INVITADO", "", ""),
        User("Hector", "hector@calificame.com", "12345678"),
        User("Mayra", "mayra@calificame.com", "12345678"),
        User("Esiel", "esiel_kar@hotmail.com", "12345678"),
    )

    var currentUser : User? = users.elementAt(0)

    fun add(user: User) = users.add(user)

    fun validUsername(username: String): Boolean {
        return !users.any { it.username == username}
    }

    fun validUser(email: String, password: String): User? {
        val usr = users.find { it.email == email }
        if (usr?.password == password)
            return usr
        return null
    }

    fun validEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}