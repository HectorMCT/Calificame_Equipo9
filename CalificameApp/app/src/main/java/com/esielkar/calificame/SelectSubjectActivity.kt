package com.esielkar.calificame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.esielkar.calificame.model.adapter.SubjectsAdapter
import com.esielkar.calificame.model.*
import com.esielkar.calificame.view.HeaderCardView

class SelectSubjectActivity : AppCompatActivity() {
    private lateinit var rec : RecyclerView
    private lateinit var headerCV : HeaderCardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_subject)

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
        rec.adapter = SubjectsAdapter(
            setOf(
                Subject(resources.getString(R.string.signature_name)),
                Subject(resources.getString(R.string.signature_name2)),
                Subject(resources.getString(R.string.signature_name3)),
                Subject(resources.getString(R.string.signature_name4)),
                Subject(resources.getString(R.string.signature_name5)),
                Subject(resources.getString(R.string.signature_name6)),
                Subject(resources.getString(R.string.signature_name7)),
                Subject(resources.getString(R.string.signature_name8)),
                Subject(resources.getString(R.string.signature_name9))
            ), onItemClickListener = {
                val intent = Intent(this, AboutUsActivity::class.java)
                //putExtra(it) TODO: Parcelable
                startActivity(intent)
            }
        )
    }
}