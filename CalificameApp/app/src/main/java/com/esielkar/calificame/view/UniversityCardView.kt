package com.esielkar.calificame.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import com.esielkar.calificame.R
import com.esielkar.calificame.databinding.UniversityCardViewBinding
import com.google.android.material.card.MaterialCardView

class UniversityCardView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : CalificameCardView(context, attrs, defStyleAttr) {

    private val binding : UniversityCardViewBinding =
        UniversityCardViewBinding.inflate(LayoutInflater.from(context), this)

    init {
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.UniversityCardView, defStyleAttr, 0)
                universityName = typedArray.getText(R.styleable.UniversityCardView_university_name) ?: resources.getText(R.string.not_defined_label)
            typedArray.recycle()
        }
    }

    var universityName
    set(value) { binding.universityName.text = value }
    get() = binding.universityName.text
}