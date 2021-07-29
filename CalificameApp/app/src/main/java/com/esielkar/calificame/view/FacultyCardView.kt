package com.esielkar.calificame.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import com.esielkar.calificame.R
import com.google.android.material.card.MaterialCardView

class FacultyCardView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {
    private var facultyNameTextView : TextView
    private var facultyProfessorsCountTextView : TextView
    private var _professorsCount : Int = 0

    init {
        LayoutInflater.from(context).inflate(R.layout.faculty_card_view, this, true)
        facultyNameTextView = findViewById(R.id.faculty_name)
        facultyProfessorsCountTextView = findViewById(R.id.faculty_professors_count)

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.FacultyCardView, defStyleAttr, 0)
            val facultyName = typedArray.getText(R.styleable.FacultyCardView_faculty_name) ?: resources.getText(R.string.not_defined_label)
            this.facultyName = facultyName
            professorsCount = typedArray.getInt(R.styleable.FacultyCardView_faculty_professors_count, 0)
            typedArray.recycle()
        }
    }

    var facultyName
        set(value) { facultyNameTextView.text = value }
        get() = facultyNameTextView.text

    var professorsCount : Int
        set(value) {
            _professorsCount = value
            facultyProfessorsCountTextView.text = resources.getString(R.string.registered_professors, _professorsCount)
        }
        get() = _professorsCount
}