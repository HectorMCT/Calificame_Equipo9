package com.esielkar.calificame

import android.app.ActivityOptions
import android.content.Intent
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
import com.esielkar.calificame.placeholder.AppContent
import com.esielkar.calificame.placeholder.UsersContent
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val navController = navHostFragment.navController

        val transitionExitXml = TransitionInflater.from(this).inflateTransition(R.transition.transition_out)

        val transitionEnterXml = TransitionInflater.from(this).inflateTransition(R.transition.transition_in)

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
                    val intent : Intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
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
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}