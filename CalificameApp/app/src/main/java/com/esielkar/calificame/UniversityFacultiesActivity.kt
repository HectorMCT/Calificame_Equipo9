package com.esielkar.calificame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Slide
import android.view.Gravity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.esielkar.calificame.utils.AppContent
import com.google.firebase.crashlytics.FirebaseCrashlytics

class UniversityFacultiesActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_university_faculties)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_list_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        //definiendo el tipo de transición
        val transition = Slide(Gravity.BOTTOM).apply {
            duration = 350
        }

        window.enterTransition = transition

        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_list_fragment)
        return if (navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()){
            AppContent.currentFaculty = null
            true
        } else false
    }
}