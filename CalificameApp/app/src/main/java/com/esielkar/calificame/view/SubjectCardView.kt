package com.esielkar.calificame.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import com.esielkar.calificame.R
import com.google.android.material.card.MaterialCardView

class SubjectCardView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {
    private var subjectNameTextView : TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.view_subject_card, this, true)
        subjectNameTextView = findViewById(R.id.subject_name)

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.SubjectCardView, defStyleAttr, 0)
            val subjectName = typedArray.getText(R.styleable.SubjectCardView_subject_name) ?: resources.getText(R.string.not_defined_label)
            subjectNameTextView.text = subjectName
            typedArray.recycle()
        }
    }
}