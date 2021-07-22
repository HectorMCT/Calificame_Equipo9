package com.esielkar.registerandlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    private lateinit var  signUpTextButton : Button
    private lateinit var  signInButton : Button
    private lateinit var  skipLoginButton : Button
    private lateinit var  forgotPasswordButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide() //Hides AppBar

        //Variables initialization
        signUpTextButton = findViewById(R.id.signUpTextButton)
        signInButton = findViewById(R.id.signInButton)
        skipLoginButton = findViewById(R.id.skipLoginTextButton)
        forgotPasswordButton = findViewById(R.id.forgotPasswordTextButton)

        //Adding Events
        signUpTextButton.setOnClickListener { skipLogin() }
        skipLoginButton.setOnClickListener { signIn() }
        signInButton.setOnClickListener { signIn() }
        forgotPasswordButton.setOnClickListener {
            Toast.makeText(applicationContext, "Función no implementada", Toast.LENGTH_LONG ).show()
        }
    }

    private fun skipLogin(){
        var toSignUpActivityIntent = Intent(this@LoginActivity, RegisterActivity::class.java)
        startActivity(toSignUpActivityIntent)
    }

    private fun signIn(){
        var toMainActivityIntent = Intent(this@LoginActivity, MainActivity::class.java)
        startActivity(toMainActivityIntent)
        finish()
    }
}