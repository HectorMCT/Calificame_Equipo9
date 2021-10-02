package com.esielkar.calificame.view.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import com.esielkar.calificame.R
import com.esielkar.calificame.databinding.ReviewCardViewBinding

class ReviewCardView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : CalificameCardView(context, attrs, defStyleAttr) {

    private val binding = ReviewCardViewBinding.inflate(LayoutInflater.from(context), this)

    init {
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.ReviewCardView, defStyleAttr, 0)

            username = typedArray.getText(R.styleable.ReviewCardView_review_username) ?: resources.getText(
                R.string.not_defined_label)

            comment = typedArray.getText(R.styleable.ReviewCardView_review_comment) ?: resources.getText(
                R.string.no_comment_label)

            satisfaction = typedArray.getInt(R.styleable.ReviewCardView_review_percentage, 0)
            typedArray.recycle()
        }
    }

    var username
        set(value) { binding.username.text = value }
        get() = binding.username.text

    var comment
        set(value) { binding.reviews.text = value }
        get() = binding.reviews.text

    var satisfaction
        set(value) { binding.circularProgressBar.progress = value }
        get() = binding.circularProgressBar.progress
}