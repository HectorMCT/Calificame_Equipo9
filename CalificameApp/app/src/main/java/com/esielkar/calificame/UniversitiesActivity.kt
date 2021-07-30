package com.esielkar.calificame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.esielkar.calificame.model.adapter.UniversitiesAdapter
import com.esielkar.calificame.model.University

class UniversitiesActivity : AppCompatActivity() {
    private lateinit var rec : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_universities)
        supportActionBar?.hide()

        rec = findViewById(R.id.rec)
        ResourcesCompat.getDrawable(resources, R.drawable.divider, null)?.let {
            rec.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL).apply {
                 setDrawable(it)
            })
        }
        //TODO: Universidades de prueba
        rec.adapter = UniversitiesAdapter(setOf(
            University(resources.getString(R.string.university_name)),
            University(resources.getString(R.string.university_name2)),
            University(resources.getString(R.string.university_name3)),
            University(resources.getString(R.string.university_name4)),
            University(resources.getString(R.string.university_name5)),
            University(resources.getString(R.string.university_name6)),
            University(resources.getString(R.string.university_name7)),
            University(resources.getString(R.string.university_name8)),
            University(resources.getString(R.string.university_name9)),
        ))

    }
}