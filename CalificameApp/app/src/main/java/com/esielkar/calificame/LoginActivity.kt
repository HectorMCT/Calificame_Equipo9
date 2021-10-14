package com.esielkar.calificame

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.esielkar.calificame.utils.AppContent
import com.esielkar.calificame.utils.UsersContent
import com.esielkar.calificame.viewmodel.UserViewModel
import com.google.firebase.crashlytics.FirebaseCrashlytics
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class LoginActivity : AppCompatActivity() {
    private val application by lazy { applicationContext as CalificameApplication }
    private val userViewModel : UserViewModel by lazy { UserViewModel(application.userRepository) }

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        preferences = getSharedPreferences(AppContent.PREFS_NAME, Context.MODE_PRIVATE)

        //Prepoblar la base de datos en la primer ejecución
        if (preferences.getBoolean(AppContent.PREPOPULATE, true)) {
            val executor: ExecutorService = Executors.newSingleThreadExecutor()
            executor.execute{
                userViewModel.prepopulate()
            }
            preferences.edit()
                .putBoolean(AppContent.PREPOPULATE, false)
                .apply()
            FirebaseCrashlytics.getInstance().log("BASEDEDATOS. SE VA A PREPOBLAR")
        }else {
            FirebaseCrashlytics.getInstance().log("BASEDEDATOS. YA FUE PREPOBLADA")
        }
        if (preferences.getBoolean(UsersContent.SP_IS_LOGGED, false)) {
            val user =  UsersContent.validUser(
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

        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_login_fragment)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}