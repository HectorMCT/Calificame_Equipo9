package com.esielkar.calificame.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.esielkar.calificame.R

class SignUpActivity : AppCompatActivity() {

    private lateinit var  signUpButton : Button
    private lateinit var  signInTextButton : Button
    private lateinit var  skipSignUpTextButton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        supportActionBar?.hide()

        //Variables initialization
        signUpButton = findViewById(R.id.signUpButton)
        signInTextButton = findViewById(R.id.signInTextButton)
        skipSignUpTextButton = findViewById(R.id.skipSignUpTextButton)

        //Adding events
        signUpButton.setOnClickListener { skipLogin() }
        skipSignUpTextButton.setOnClickListener { skipLogin() }
        signInTextButton.setOnClickListener { signIn() }
    }

    private fun skipLogin() {
        var toUniversityActivityIntent = Intent(this, UniversityActivity::class.java)
        startActivity(toUniversityActivityIntent)
        finish()
    }

    private fun signIn(){
        var toSignInActivityIntent = Intent(this@SignUpActivity, SignInActivity::class.java)
        startActivity(toSignInActivityIntent)
        finish()
    }
}