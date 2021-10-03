package com.esielkar.calificame.model.data

import com.esielkar.calificame.model.User
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository(
    private val userDao: UserDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun signup(user : User) = userDao.insertUser(user)
    suspend fun login(email : String, password : String) : User? {
        return userDao.getUserByEmailAndPassword(email, password)
    }

    suspend fun findUser(email: String) : User? {
        return userDao.getUserByEmail(email)
    }

    suspend fun populateUsers(users: List<User>) = withContext(ioDispatcher) {
        return@withContext userDao.insertAll(users)
    }
}