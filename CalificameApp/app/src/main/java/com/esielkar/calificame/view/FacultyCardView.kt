package com.esielkar.calificame.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.esielkar.calificame.R

class FacultyCardView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {
    private var facultyNameTextView : TextView
    private var facultyProfessorsCountTextView : TextView

    init {
        cardElevation = 16.0f
        LayoutInflater.from(context).inflate(R.layout.view_faculty_card, this, true)
        facultyNameTextView = findViewById(R.id.faculty_name)
        facultyProfessorsCountTextView = findViewById(R.id.faculty_professors_count)

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.FacultyCardView, defStyleAttr, 0)
            val facultyName = typedArray.getText(R.styleable.FacultyCardView_faculty_name) ?: resources.getText(R.string.not_defined_label)
            facultyNameTextView.text = facultyName
            val facultyProfessorsCount = typedArray.getInt(R.styleable.FacultyCardView_faculty_professors_count, 0)
            facultyProfessorsCountTextView.text = resources.getString(R.string.registered_professors, facultyProfessorsCount)
            typedArray.recycle()
        }
    }
}