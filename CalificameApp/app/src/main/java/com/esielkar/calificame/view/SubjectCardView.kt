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
    private val subjectNameTextView : TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.subject_card_view, this, true)
        subjectNameTextView = findViewById(R.id.subject_name)

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.SubjectCardView, defStyleAttr, 0)
            val subjectName = typedArray.getText(R.styleable.SubjectCardView_subject_name) ?: resources.getText(R.string.not_defined_label)
            this.subjectName = subjectName
            typedArray.recycle()
        }
    }

    var subjectName : CharSequence
    set(value) {subjectNameTextView.text = value}
    get() = subjectNameTextView.text
}