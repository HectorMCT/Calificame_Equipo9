package com.esielkar.calificame.placeholder

import com.esielkar.calificame.model.User

object UsersContent {
    private val users = mutableSetOf<User>(
        User("INVITADO", "", ""),
        User("Esiel15", "esiel_kar@hotmail.com", "123456")
    )

    fun add(user: User) = users.add(user)
    fun getUser(email: String, password: String): User? {
        users.forEach {
            if (it.email == email && it.password == password)
                return it
        }
        return null
    }
}