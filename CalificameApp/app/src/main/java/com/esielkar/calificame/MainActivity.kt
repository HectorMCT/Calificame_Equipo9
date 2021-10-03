package com.esielkar.calificame

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.View
import android.widget.TextView
import androidx.customview.widget.Openable
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.esielkar.calificame.utils.AppContent
import com.esielkar.calificame.utils.UsersContent
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        preferences = getSharedPreferences(AppContent.PREFS_NAME, Context.MODE_PRIVATE)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_main_fragment) as NavHostFragment
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val navController = navHostFragment.navController

        val transitionExitXml = TransitionInflater.from(this).inflateTransition(R.transition.transition_out_main).apply {
            excludeTarget(window.decorView.findViewById<View>(R.id.action_bar_container), true)
            excludeTarget(android.R.id.statusBarBackground, true)
            excludeTarget(android.R.id.navigationBarBackground, true)
            excludeTarget(R.id.nav_host_main_fragment, true)
        }

        val transitionEnterXml = TransitionInflater.from(this).inflateTransition(R.transition.transition_in_main).apply {
            excludeTarget(window.decorView.findViewById<View>(R.id.action_bar_container), true)
            excludeTarget(android.R.id.statusBarBackground, true)
            excludeTarget(android.R.id.navigationBarBackground, true)
            excludeTarget(R.id.nav_host_main_fragment, true)
        }

        window.exitTransition = transitionExitXml
        window.enterTransition = transitionEnterXml

        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        //findViewById<NavigationView>(R.id.nav_view).setupWithNavController(navController)
        setupNavigationView(navController)
    }

    private fun setupNavigationView(navController : NavController) {
        val navView = findViewById<NavigationView>(R.id.nav_view)
        val header = navView.getHeaderView(0)
        header.setOnClickListener {
            navController.navigate(R.id.action_global_userInformationFragment);
            if (navView.parent is Openable) {
                (navView.parent as Openable).close()
            }
        }

        header.findViewById<TextView>(R.id.header_username).text = UsersContent.currentUser?.username
        header.findViewById<TextView>(R.id.header_email).text = UsersContent.currentUser?.email
        //NavigationUI.setupWithNavController(navView, navController)
        navView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.toUniversities -> {
                    AppContent.currentFaculty = null
                    val intent = Intent(this, UniversityFacultiesActivity::class.java)
                    startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
                    finish()
                    true
                }

                R.id.toFaculties -> {
                    val intent = Intent(this, UniversityFacultiesActivity::class.java)
                    startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle()) //Enviar university
                    finish()
                    true
                }

                R.id.toSignOut -> {
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
                    preferences.edit()
                        .putBoolean(UsersContent.SP_IS_LOGGED, false)
                        .remove(UsersContent.SP_EMAIL)
                        .remove(UsersContent.SP_PASSWORD)
                        .apply()
                    finish()
                    true
                }
                else -> {
                    if (NavigationUI.onNavDestinationSelected(it, navController)) {
                        if (navView.parent is Openable) {
                            (navView.parent as Openable).close()
                        }
                    }
                    true
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_main_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}