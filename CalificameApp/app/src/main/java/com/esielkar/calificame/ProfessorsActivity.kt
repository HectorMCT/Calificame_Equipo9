package com.esielkar.calificame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.esielkar.calificame.view.HeaderCardView

class ProfessorsActivity : AppCompatActivity() {
    private lateinit var rec : RecyclerView
    private lateinit var headerCV : HeaderCardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_professors)
    }
}