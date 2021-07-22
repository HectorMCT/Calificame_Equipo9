package com.esielkar.registerandlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RegisterActivity : AppCompatActivity() {
    private lateinit var  signInTextButton : Button
    private lateinit var  signUpButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        supportActionBar?.hide() //Hides AppBar

        signUpButton = findViewById(R.id.signUpButton)
        signInTextButton = findViewById(R.id.signInTextButton)

        signUpButton.setOnClickListener {
            var toMainActivityIntent = Intent(this@RegisterActivity, MainActivity::class.java)
            startActivity(toMainActivityIntent)
            finish()
        }
        signInTextButton.setOnClickListener {
            finish()
        }
    }
}