package com.esielkar.calificame.model.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.esielkar.calificame.model.User

@Database(entities = arrayOf(User::class), version = 1)
abstract class CalificameDB : RoomDatabase() {
    companion object {
        private var calificameDB: CalificameDB? = null
        const val  DB_NAME = "Calificame"

        fun getInstance(context: Context) : CalificameDB? {
            if (calificameDB == null) {
                synchronized(CalificameDB::class) {
                    calificameDB = Room.databaseBuilder(
                        context.applicationContext,
                        CalificameDB::class.java,
                        DB_NAME
                    ).fallbackToDestructiveMigration().build()
                }
            }
            return calificameDB
        }
    }

    abstract fun userDao() : UserDao
}