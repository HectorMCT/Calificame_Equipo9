package com.esielkar.calificame.view.components

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
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
            indicatorColor(value)
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

    private fun indicatorColor(value: Int){
        val cpi = binding.circularProgressIndicator
        when (value) {
            in 0..10 -> cpi.setIndicatorColor(ResourcesCompat.getColor(resources, R.color.red, null))
            in 11..35 -> cpi.setIndicatorColor(ResourcesCompat.getColor(resources, R.color.light_yellow, null))
            in 36..65 -> cpi.setIndicatorColor(ResourcesCompat.getColor(resources, R.color.light_orange, null))
            in 66..90 -> cpi.setIndicatorColor(ResourcesCompat.getColor(resources, R.color.light_blue, null))
            else -> cpi.setIndicatorColor(ResourcesCompat.getColor(resources, R.color.light_green, null))
        }
    }

   var trackThickness
       set(value) { binding.circularProgressIndicator.trackThickness = value }
       get() = binding.circularProgressIndicator.trackThickness
}