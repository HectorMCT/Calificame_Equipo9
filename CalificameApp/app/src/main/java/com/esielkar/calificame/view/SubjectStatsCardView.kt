package com.esielkar.calificame.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import com.esielkar.calificame.R
import com.google.android.material.card.MaterialCardView

class SubjectStatsCardView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {
    private var subjectNameTextView : TextView
    private var subjectReviewsCountTextView : TextView

    init {
        cardElevation = 16.0f
        LayoutInflater.from(context).inflate(R.layout.view_subject_reviews_card, this, true)
        subjectNameTextView = findViewById(R.id.subject_name)
        subjectReviewsCountTextView = findViewById(R.id.subject_reviews_count)

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.SubjectStatsCardView, defStyleAttr, 0)
            val subjectName = typedArray.getText(R.styleable.SubjectStatsCardView_subject_stats_name) ?: resources.getText(R.string.not_defined_label)
            subjectNameTextView.text = subjectName
            val subjectReviewsCount = typedArray.getInt(R.styleable.SubjectStatsCardView_subject_reviews_count, 0)
            subjectReviewsCountTextView.text = resources.getString(R.string.registered_reviews, subjectReviewsCount)
            typedArray.recycle()
        }
    }
}