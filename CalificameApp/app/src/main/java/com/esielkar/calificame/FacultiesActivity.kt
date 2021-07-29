package com.esielkar.calificame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.esielkar.calificame.adapter.FacultiesAdapter
import com.esielkar.calificame.model.Faculty
import com.esielkar.calificame.model.Professor
import com.esielkar.calificame.model.ProfessorStats
import com.esielkar.calificame.model.University
import com.esielkar.calificame.view.HeaderCardView

class FacultiesActivity : AppCompatActivity() {
    private lateinit var rec : RecyclerView
    private lateinit var headerCV : HeaderCardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faculty)

        //TODO: Universidad con facultades de prueba
        val u = University(resources.getString(R.string.university_name),
            setOf(
                Faculty(resources.getString(R.string.faculty_name),
                    mapOf(
                        Professor("1") to ProfessorStats(),
                        Professor("2") to ProfessorStats(),
                        Professor("3") to ProfessorStats(),
                        Professor("4") to ProfessorStats(),
                        Professor("5") to ProfessorStats(),
                        Professor("6") to ProfessorStats()
                    )
                ),
                Faculty(resources.getString(R.string.faculty_name2),
                    mapOf(
                        Professor("1") to ProfessorStats(),
                        Professor("2") to ProfessorStats(),
                        Professor("3") to ProfessorStats()
                    )
                ),
                Faculty(resources.getString(R.string.faculty_name3),
                    mapOf(
                        Professor("1") to ProfessorStats(),
                        Professor("2") to ProfessorStats()
                    )
                ),
                Faculty(resources.getString(R.string.faculty_name4),
                    mapOf(
                        Professor("1") to ProfessorStats(),
                        Professor("2") to ProfessorStats(),
                        Professor("3") to ProfessorStats(),
                        Professor("4") to ProfessorStats(),
                    )
                ),
            )
        )

        headerCV = findViewById(R.id.headerCV)
        headerCV.title = u.name


        rec = findViewById(R.id.rec)
        ResourcesCompat.getDrawable(resources, R.drawable.divider, null)?.let {
            rec.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL).apply {
                setDrawable(it)
            })
        }
        rec.adapter = FacultiesAdapter(u.faculties)
    }
}