package com.esielkar.calificame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.esielkar.calificame.model.adapter.SubjectStatsAdapter
import com.esielkar.calificame.model.*
import com.esielkar.calificame.utils.SubjectWithInfo
import com.esielkar.calificame.view.HeaderCardView

class SubjectsActivity : AppCompatActivity() {
    private lateinit var rec : RecyclerView
    private lateinit var headerCV : HeaderCardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subjects)

        //TODO: Materias de prueba
        val su1 = Subject(resources.getString(R.string.signature_name))
        val su2 = Subject(resources.getString(R.string.signature_name2))
        val su3 = Subject(resources.getString(R.string.signature_name3))
        val su4 = Subject(resources.getString(R.string.signature_name4))
        val su5 = Subject(resources.getString(R.string.signature_name5))
        val su6 = Subject(resources.getString(R.string.signature_name6))
        val su7 = Subject(resources.getString(R.string.signature_name7))
        val su8 = Subject(resources.getString(R.string.signature_name8))
        val su9 = Subject(resources.getString(R.string.signature_name9))

        //TODO: Universidad con facultad de prueba
        val u = University(resources.getString(R.string.university_name), setOf(
            Faculty(resources.getString(R.string.faculty_name),
            mapOf(
                Professor(resources.getString(R.string.professor_name)) to ProfessorStats()
            ))
        ))
        headerCV = findViewById(R.id.headerCV)

        //Todo: Funciona por los datos hardcodeados
        headerCV.title = u.faculties.first().professors.first().name
        headerCV.subtitle = u.faculties.firstOrNull()?.name
        headerCV.overline = u.name

        rec = findViewById(R.id.rec)
        ResourcesCompat.getDrawable(resources, R.drawable.divider, null)?.let {
            rec.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL).apply {
                setDrawable(it)
            })
        }
        rec.adapter = SubjectStatsAdapter(
            listOf(
                SubjectWithInfo(su1, 100, 60),
                SubjectWithInfo(su2, 54, 29),
                SubjectWithInfo(su3, 250, 150),
                SubjectWithInfo(su4, 15, 30),
                SubjectWithInfo(su5, 32, 10),
                SubjectWithInfo(su6, 56, 30),
                SubjectWithInfo(su7, 169, 100),
                SubjectWithInfo(su8, 345, 267),
                SubjectWithInfo(su9, 68, 18)
            ), onItemClickListener = {
                val intent = Intent(this, AddReviewActivity::class.java)
                //putExtra(it) TODO: Parcelable
                startActivity(intent)
            }
        )
    }
}