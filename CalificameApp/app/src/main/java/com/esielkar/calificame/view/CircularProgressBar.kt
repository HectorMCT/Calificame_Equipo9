package com.esielkar.calificame.view

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import android.widget.TextView
import com.esielkar.calificame.R
import com.esielkar.calificame.databinding.CircularProgressBarBinding
import com.google.android.material.progressindicator.CircularProgressIndicator

class CircularProgressBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private val binding = CircularProgressBarBinding.inflate(LayoutInflater.from(context), this)
    private var _progress = 0

    var progress
        set(value) {
            _progress = value
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                binding.circularProgressIndicator.setProgress(_progress, true)
            } else binding.circularProgressIndicator.progress = _progress
            binding.progress.text = resources.getString(R.string.progress_percentage, _progress, '%')
        }
        get() = _progress

    var textSize
        set(value) { binding.progress.textSize = value }
        get() = binding.progress.textSize

    var indicatorSize
        set(value) { binding.circularProgressIndicator.indicatorSize = value }
        get() = binding.circularProgressIndicator.indicatorSize

   var trackThickness
       set(value) { binding.circularProgressIndicator.trackThickness = value }
       get() = binding.circularProgressIndicator.trackThickness
}