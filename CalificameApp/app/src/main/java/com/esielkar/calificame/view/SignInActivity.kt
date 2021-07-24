package com.esielkar.calificame.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.esielkar.calificame.R

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_in)
        supportActionBar?.hide()

    }
}