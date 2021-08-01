package com.esielkar.calificame.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import com.esielkar.calificame.R
import com.esielkar.calificame.databinding.SubjectStatsCardViewBinding
import com.google.android.material.card.MaterialCardView

class SubjectStatsCardView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : CalificameCardView(context, attrs, defStyleAttr) {

    private val binding : SubjectStatsCardViewBinding =
        SubjectStatsCardViewBinding.inflate(LayoutInflater.from(context), this)
    private var _statsCount : Int = 0
    private var _reviewsCount : Int = 0


    init {
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.SubjectStatsCardView, defStyleAttr, 0)
            this.subjectName = typedArray.getText(R.styleable.SubjectStatsCardView_subject_stats_name) ?: resources.getText(R.string.not_defined_label)
            statsCount = typedArray.getInt(R.styleable.SubjectStatsCardView_subject_stats_count, 0)
            reviewsCount = typedArray.getInt(R.styleable.SubjectStatsCardView_subject_reviews_count, 0)
            typedArray.recycle()
        }
    }

    var subjectName : CharSequence
        set(value) {binding.subjectName.text = value}
        get() = binding.subjectName.text

    var statsCount
        set(value) {
            _statsCount = value
            binding.subjectStatsCount.text = resources.getString(R.string.registered_stats, _statsCount)
        }
        get() = _statsCount

    var reviewsCount
        set(value) {
            _reviewsCount = value
            binding.subjectReviewsCount.text = resources.getString(R.string.registered_reviews, _reviewsCount)
        }
        get() = _reviewsCount
}