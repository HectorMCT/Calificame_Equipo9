package com.esielkar.calificame.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import com.esielkar.calificame.R
import com.esielkar.calificame.databinding.FacultyCardViewBinding
import com.google.android.material.card.MaterialCardView

class FacultyCardView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : CalificameCardView(context, attrs, defStyleAttr) {
    private var binding = FacultyCardViewBinding.inflate(LayoutInflater.from(context), this)
    private var _professorsCount : Int = 0

    init {
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.FacultyCardView, defStyleAttr, 0)
            facultyName = typedArray.getText(R.styleable.FacultyCardView_faculty_name) ?: resources.getText(R.string.not_defined_label)
            professorsCount = typedArray.getInt(R.styleable.FacultyCardView_faculty_professors_count, 0)
            typedArray.recycle()
        }
    }

    var facultyName
        set(value) { binding.facultyName.text = value }
        get() = binding.facultyName.text

    var professorsCount : Int
        set(value) {
            _professorsCount = value
            binding.facultyProfessorsCount.text = resources.getString(R.string.registered_professors, _professorsCount)
        }
        get() = _professorsCount
}