package com.esielkar.calificame.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.esielkar.calificame.R

class SignInActivity : AppCompatActivity() {

    private lateinit var  signInButton : Button
    private lateinit var  signUpTextButton : Button
    private lateinit var  skipLoginTextButton : Button
    private lateinit var  forgotPasswordTextButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_in)

        supportActionBar?.hide()

        //Variables initialization
        signInButton = findViewById(R.id.signInButton)
        signUpTextButton = findViewById(R.id.signUpTextButton)
        skipLoginTextButton = findViewById(R.id.skipSignUpTextButton)
        forgotPasswordTextButton = findViewById(R.id.forgotPasswordTextButton)

        //Adding events
        signInButton.setOnClickListener { skipLogin() }
        skipLoginTextButton.setOnClickListener { skipLogin() }
        signUpTextButton.setOnClickListener { signUp() }
        forgotPasswordTextButton.setOnClickListener(object : View.OnClickListener {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            override fun onClick(v: View?) {
                forgotPassword()
            }

        })

    }

    private fun skipLogin() {
        var toUniversityActivityIntent = Intent(this@SignInActivity, UniversityActivity::class.java)
        startActivity(toUniversityActivityIntent)
        finish()
    }

    private fun signUp(){
        var toSignUpActivityIntent = Intent(this@SignInActivity, SignUpActivity::class.java)
        startActivity(toSignUpActivityIntent)
        finish()
    }

    private fun forgotPassword(){
        var toPasswordForgottenActivityIntent = Intent(this@SignInActivity, PasswordForgottenActivity::class.java)
        startActivity(toPasswordForgottenActivityIntent)
    }
}