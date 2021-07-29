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
    private var statsCountTextView : TextView
    private var _statsCount : Int = 0
    private var reviewsCountTextView : TextView
    private var _reviewsCount : Int = 0

    init {
        LayoutInflater.from(context).inflate(R.layout.professor_card_view, this, true)
        professorNameTextView = findViewById(R.id.professor_name)
        statsCountTextView = findViewById(R.id.professor_stats_count)
        reviewsCountTextView = findViewById(R.id.professor_reviews_count)

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.ProfessorCardView, defStyleAttr, 0)
            val professorName = typedArray.getText(R.styleable.ProfessorCardView_professor_name) ?: resources.getText(R.string.not_defined_label)
            this.professorName = professorName
            statsCount = typedArray.getInt(R.styleable.ProfessorCardView_professor_stats_count, 0)
            reviewsCount = typedArray.getInt(R.styleable.ProfessorCardView_professor_reviews_count, 0)
            typedArray.recycle()
        }
    }

    var professorName
        set(value) { professorNameTextView.text = value }
        get() = professorNameTextView.text

    var statsCount
        set(value) {
            _statsCount = value
            statsCountTextView.text = resources.getString(R.string.registered_stats, _statsCount)
        }
        get() = _statsCount

    var reviewsCount
        set(value) {
            _reviewsCount = value
            reviewsCountTextView.text = resources.getString(R.string.registered_reviews, _reviewsCount)
        }
        get() = _reviewsCount
}