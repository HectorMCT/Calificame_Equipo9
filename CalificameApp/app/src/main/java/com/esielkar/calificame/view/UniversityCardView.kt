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
    private val universityNameTextView : TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.university_card_view, this, true)
        universityNameTextView = findViewById(R.id.university_name)

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.UniversityCardView, defStyleAttr, 0)
            val universityName = typedArray.getText(R.styleable.UniversityCardView_university_name) ?: resources.getText(R.string.not_defined_label)
            this.universityName = universityName
            typedArray.recycle()
        }
    }

    var universityName
    set(value) { universityNameTextView.text = value }
    get() = universityNameTextView.text
}