package com.esielkar.calificame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.esielkar.calificame.model.User
import com.google.android.material.textfield.TextInputLayout

class SignUpActivity : AppCompatActivity() {

    private lateinit var  signUpButton : Button
    private lateinit var  signInTextButton : Button
    private lateinit var  skipSignUpTextButton : Button

    //Texto
    private lateinit var username : TextInputLayout
    private lateinit var email : TextInputLayout
    private lateinit var password : TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        supportActionBar?.hide()

        //Variables initialization
        signUpButton = findViewById(R.id.signUpButton)
        signInTextButton = findViewById(R.id.signInTextButton)
        skipSignUpTextButton = findViewById(R.id.skipSignUpTextButton)

        username = findViewById(R.id.usernameField)
        email = findViewById(R.id.emailField)
        password = findViewById(R.id.passwordField)

        //Adding events
        signUpButton.setOnClickListener(object : View.OnClickListener {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            override fun onClick(v: View?) {
                if(validarData(username, email, password)){
                    skipLogin()
                }
            }
        })
        skipSignUpTextButton.setOnClickListener { skipLogin() }
        signInTextButton.setOnClickListener { signIn() }
    }

    private fun validarData(username: TextInputLayout, email: TextInputLayout, password: TextInputLayout): Boolean{
        val usr = username.editText?.text.toString()
        val correo = email.editText?.text.toString()
        val pass = password.editText?.text.toString()
        when {
            usr.isNotBlank() && pass.isNotBlank() && correo.isNotBlank() -> {
                return if(validUsername(usr) && validEmail(email.editText?.text.toString())){
                    usuarios.add(User(usr,  correo, pass))
                    true
                }else{
                    username.error = getString(R.string.error_Username)
                    password.error = getString(R.string.error_Password)
                    email.error = getString(R.string.error_Email)
                    false
                }
            }
            else -> {
                username.error = getString(R.string.error_noUsername)
                email.error = getString(R.string.error_noEmail)
                password.error = getString(R.string.error_noPassword)
                return false
            }
        }
    }

    private fun validUsername(username: String): Boolean {
        return !usuarios.any { it.username == username}
    }

    private fun validPassword(email: String, password: String): Boolean {
        return true
    }

    private fun validEmail(email: String): Boolean {
         if (android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
             return !usuarios.any { it.email == email }
         }
        return false
    }

    private fun skipLogin() {
        var toUniversityActivityIntent = Intent(this, UniversitiesActivity::class.java)
        startActivity(toUniversityActivityIntent)
        finish()
    }

    private fun signIn(){
        var toSignInActivityIntent = Intent(this@SignUpActivity, SignInActivity::class.java)
        startActivity(toSignInActivityIntent)
        finish()
    }
}