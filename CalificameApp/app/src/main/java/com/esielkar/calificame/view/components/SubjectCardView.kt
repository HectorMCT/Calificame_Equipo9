package com.esielkar.calificame.view.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import com.esielkar.calificame.R
import com.esielkar.calificame.databinding.SubjectCardViewBinding

class SubjectCardView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : CalificameCardView(context, attrs, defStyleAttr) {

    private val binding = SubjectCardViewBinding.inflate(LayoutInflater.from(context), this)

    init {
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.SubjectCardView, defStyleAttr, 0)
            subjectName = typedArray.getText(R.styleable.SubjectCardView_subject_name) ?: resources.getText(R.string.not_defined_label)
            typedArray.recycle()
        }
    }

    var subjectName : CharSequence
    set(value) {binding.subjectName.text = value}
    get() = binding.subjectName.text
}