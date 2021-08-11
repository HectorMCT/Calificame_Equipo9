package com.esielkar.calificame.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import com.esielkar.calificame.R
import com.esielkar.calificame.databinding.ProfessorCardViewBinding
import com.google.android.material.card.MaterialCardView

class ProfessorCardView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : CalificameCardView(context, attrs, defStyleAttr) {

    private val binding = ProfessorCardViewBinding.inflate(LayoutInflater.from(context), this)
    private var _statsCount : Int = 0
    private var _reviewsCount : Int = 0

    init {
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.ProfessorCardView, defStyleAttr, 0)
            professorName = typedArray.getText(R.styleable.ProfessorCardView_professor_name) ?: resources.getText(R.string.not_defined_label)
            percentage = typedArray.getInt(R.styleable.ProfessorCardView_professor_percentage, 0)
            statsCount = typedArray.getInt(R.styleable.ProfessorCardView_professor_stats_count, 0)
            reviewsCount = typedArray.getInt(R.styleable.ProfessorCardView_professor_reviews_count, 0)
            typedArray.recycle()
        }
    }

    var professorName
        set(value) { binding.professorName.text = value }
        get() = binding.professorName.text

    var statsCount
        set(value) {
            _statsCount = value
            binding.professorStatsCount.text = resources.getString(R.string.registered_stats, _statsCount)
        }
        get() = _statsCount

    var reviewsCount
        set(value) {
            _reviewsCount = value
            binding.professorReviewsCount.text = resources.getString(R.string.registered_reviews, _reviewsCount)
        }
        get() = _reviewsCount

    var percentage
        set(value) { binding.circularProgressBar.progress = value }
        get() = binding.circularProgressBar.progress
}