package com.esielkar.calificame.model.data

import androidx.room.*
import com.esielkar.calificame.model.User

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: User) : Long

    @Insert
    suspend fun insertAll(users : List<User>) : List<Long>

    @Query("SELECT * FROM Users WHERE email = :email")
    suspend fun getUserByEmail(email : String): User?

    @Query("SELECT * FROM Users WHERE email = :email AND password = :password")
    suspend fun getUserByEmailAndPassword(email : String, password : String): User?
}