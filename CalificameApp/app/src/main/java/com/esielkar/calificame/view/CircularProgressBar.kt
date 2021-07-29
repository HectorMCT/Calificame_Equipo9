package com.esielkar.calificame.view

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import android.widget.TextView
import com.esielkar.calificame.R
import com.google.android.material.progressindicator.CircularProgressIndicator

class CircularProgressBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private val circularProgressIndicator : CircularProgressIndicator
    private val progressTextView : TextView

    private var _progress = 0

    init {
        LayoutInflater.from(context).inflate(R.layout.circular_progress_bar, this, true)
        circularProgressIndicator = findViewById(R.id.circularProgressIndicator)
        progressTextView = findViewById(R.id.progressTextView)
    }

    var progress
        set(value) {
            _progress = value
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                circularProgressIndicator.setProgress(_progress, true)
            } else circularProgressIndicator.progress = _progress
            progressTextView.text = resources.getString(R.string.progress_percentage, _progress, '%')
        }
        get() = _progress

    var textSize
        set(value) { progressTextView.textSize = value }
        get() = progressTextView.textSize

    var indicatorSize
        set(value) { circularProgressIndicator.indicatorSize = value }
        get() = circularProgressIndicator.indicatorSize

   var trackThickness
       set(value) { circularProgressIndicator.trackThickness = value }
       get() = circularProgressIndicator.trackThickness
}