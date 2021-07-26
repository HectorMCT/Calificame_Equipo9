package com.esielkar.calificame.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import com.esielkar.calificame.R
import com.google.android.material.card.MaterialCardView

class UniversityCardView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {
    private var univeristyNameTextView : TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.view_university_card, this, true)
        univeristyNameTextView = findViewById(R.id.university_name)

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.UniversityCardView, defStyleAttr, 0)
            val universityName = typedArray.getText(R.styleable.UniversityCardView_university_name) ?: resources.getText(R.string.not_defined_label)
            univeristyNameTextView.text = universityName
            typedArray.recycle()
        }
    }
}