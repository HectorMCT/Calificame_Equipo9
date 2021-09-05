package com.esielkar.calificame

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Slide
import android.transition.TransitionInflater
import android.view.Gravity
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.esielkar.calificame.placeholder.AppContent
import com.esielkar.calificame.placeholder.UsersContent

class LoginActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        preferences = getSharedPreferences(AppContent.PREFS_NAME, Context.MODE_PRIVATE)
        if (preferences.getBoolean(UsersContent.SP_IS_LOGGED, false)) {
            val user = UsersContent.validUser(
                preferences.getString(UsersContent.SP_EMAIL, "")!!,
                preferences.getString(UsersContent.SP_PASSWORD, "")!!
            )
            user?.let {
                UsersContent.currentUser = it
                startActivity(Intent(this, UniversityFacultiesActivity::class.java))
                finish()
            }
        }

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_login_fragment) as NavHostFragment
        val navController = navHostFragment.navController



        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_login_fragment)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}