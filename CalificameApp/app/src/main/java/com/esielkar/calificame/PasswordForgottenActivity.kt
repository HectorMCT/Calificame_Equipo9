package com.esielkar.calificame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PasswordForgottenActivity : AppCompatActivity() {
    private lateinit var  sendButton : Button
    private lateinit var  cancelButton : Button
    private lateinit var  signUpTextButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_forgotten)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //Variables initialization
        sendButton = findViewById(R.id.sendButton)
        cancelButton = findViewById(R.id.cancelButton)
        signUpTextButton = findViewById(R.id.signUpButton)

        //Adding events
        sendButton.setOnClickListener { finish() }
        cancelButton.setOnClickListener { finish() }
        signUpTextButton.setOnClickListener { signUp() }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun signUp(){
        var toSignUpActivityIntent = Intent(this, SignUpActivity::class.java)
        startActivity(toSignUpActivityIntent)
        finish()
    }

}