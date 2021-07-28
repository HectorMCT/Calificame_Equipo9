package com.esielkar.calificame.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import com.esielkar.calificame.R
import com.google.android.material.card.MaterialCardView

class TeacherCardView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {
    private var teacherNameTextView : TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.view_teacher_card, this, true)
        teacherNameTextView = findViewById(R.id.teacher_name)

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.TeacherCardView, defStyleAttr, 0)
            val teacherName = typedArray.getText(R.styleable.TeacherCardView_teacher_name) ?: resources.getText(R.string.not_defined_label)
            teacherNameTextView.text = teacherName
            typedArray.recycle()
        }
    }
}