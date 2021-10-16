package com.esielkar.calificame

import android.app.Application
import com.esielkar.calificame.model.data.UserRepository

class CalificameApplication : Application() {
    val userRepository : UserRepository
        get() = UserRepository()
}