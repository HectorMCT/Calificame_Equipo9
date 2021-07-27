package com.esielkar.calificame.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.annotation.ColorInt
import com.esielkar.calificame.R
import com.google.android.material.card.MaterialCardView

class StatsCardView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {

    private val titleTextView : TextView
    private val subtitleTextView : TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.stats_card_view, this, true)
        titleTextView = findViewById(R.id.title)
        subtitleTextView = findViewById(R.id.subtitle)

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.StatsCardView, defStyleAttr, 0)
            val title = typedArray.getText(R.styleable.StatsCardView_title) ?: resources.getText(R.string.not_defined_label)
            this.title = title

            val subtitle = typedArray.getText(R.styleable.StatsCardView_subtitle) ?: resources.getText(R.string.not_defined_label)
            val subtitleColor = typedArray.getColor(R.styleable.StatsCardView_subtitleTextColor, subtitleTextView.textColors.defaultColor)
            this.subtitle = subtitle
            this.subtitleColor = subtitleColor
            typedArray.recycle()
        }
    }

    var title : CharSequence
        set(value) { titleTextView.text = value }
        get() = titleTextView.text
    var subtitle : CharSequence
        set(value) { subtitleTextView.text = value }
        get() = subtitleTextView.text

    var subtitleColor : Int
        set(@ColorInt value) = subtitleTextView.setTextColor(value)
        get() = subtitleTextView.currentTextColor

}