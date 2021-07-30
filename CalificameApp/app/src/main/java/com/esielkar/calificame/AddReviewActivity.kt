package com.esielkar.calificame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AddReviewActivity : AppCompatActivity() {
    //TODO: Botón de prueba
    lateinit var button : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_review)

        //TODO: Código de prueba
        button = findViewById(R.id.button2)
        button.setOnClickListener {
            val intent = Intent(this, SelectSubjectActivity::class.java)
            //putExtra(it) TODO: Parcelable
            startActivity(intent)
        }
    }
}