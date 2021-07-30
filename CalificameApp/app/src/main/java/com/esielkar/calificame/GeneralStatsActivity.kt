package com.esielkar.calificame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class GeneralStatsActivity : AppCompatActivity() {
    //TODO boton de prueba
    lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_general_stats)

        //TODO: Código de prueba para mostrar navegación
        button = findViewById(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, SubjectsActivity::class.java)
            startActivity(intent)
        }
    }
}