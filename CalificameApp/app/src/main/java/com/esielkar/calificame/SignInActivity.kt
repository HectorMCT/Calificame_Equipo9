package com.esielkar.calificame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.esielkar.calificame.model.User
import com.google.android.material.textfield.TextInputLayout

val usuarios = mutableListOf<User>(User("hector", "hector@calificame.com", "12345678"),
                            User("Eziel", "eziel@calificame.com", "12345678"),
                            User("Mayra", "mayra@calificame.com", "12345678"))

class SignInActivity : AppCompatActivity() {

    private lateinit var signInButton : Button
    private lateinit var signUpTextButton : Button
    private lateinit var skipLoginTextButton : Button
    private lateinit var forgotPasswordTextButton : Button

    //Texto
    private lateinit var email : TextInputLayout
    private lateinit var password : TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_in)

        supportActionBar?.hide()

        //Variables initialization
        signInButton = findViewById(R.id.signInButton)
        signUpTextButton = findViewById(R.id.signUpTextButton)
        skipLoginTextButton = findViewById(R.id.skipSignUpTextButton)
        forgotPasswordTextButton = findViewById(R.id.forgotPasswordTextButton)

        email = findViewById(R.id.emailField)
        password = findViewById(R.id.passwordField)
        //Adding events
        signInButton.setOnClickListener(object : View.OnClickListener {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            override fun onClick(v: View?) {
                if(validarData(email, password)){
                    skipLogin()
                }
            }
        })

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

    private fun validarData(email: TextInputLayout, password: TextInputLayout): Boolean{

        val correo = email.editText?.text.toString()
        val pass = password.editText?.text.toString()

        when {
            pass.isNotBlank() && correo.isNotBlank() -> {
                return if(validEmail(correo) && validPassword(correo, pass)){
                    true
                }else{
                    password.error = getString(R.string.error_Password)
                    email.error = getString(R.string.error_Email)
                    false
                }
            }
            else -> {
                email.error = getString(R.string.error_noEmail)
                password.error = getString(R.string.error_noPassword)
                return false
            }
        }
    }

    private fun validPassword(email: String, password: String): Boolean {
        val usr = usuarios.find { it.email == email }
        return usr?.password == password
    }

    private fun validEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun skipLogin() {
        var toUniversityActivityIntent = Intent(this@SignInActivity, UniversitiesActivity::class.java)
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