package com.esielkar.calificame.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import com.esielkar.calificame.R
import com.google.android.material.card.MaterialCardView

class ProfessorCardView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {
    private var professorNameTextView : TextView
    private var professorReviewsCountTextView : TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.view_professor_card, this, true)
        professorNameTextView = findViewById(R.id.professor_name)
        professorReviewsCountTextView = findViewById(R.id.professor_reviews_count)

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.ProfessorCardView, defStyleAttr, 0)
            val professorName = typedArray.getText(R.styleable.ProfessorCardView_professor_name) ?: resources.getText(R.string.not_defined_label)
            professorNameTextView.text = professorName
            val professorReviewsCount = typedArray.getInt(R.styleable.ProfessorCardView_professor_reviews_count, 0)
            professorReviewsCountTextView.text = resources.getString(R.string.registered_reviews, professorReviewsCount)
            typedArray.recycle()
        }
    }
}