package com.esielkar.calificame.view

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.Gravity
import android.widget.LinearLayout
import androidx.annotation.ColorInt
import androidx.core.content.res.ResourcesCompat
import com.esielkar.calificame.R
import com.google.android.material.textview.MaterialTextView

open abstract class StatsCardView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : CalificameCardView(context, attrs, defStyleAttr) {

    private val ll = LinearLayout(context)
    private val _title : MaterialTextView = MaterialTextView(context, null, defStyleAttr)
    private var _stats = 0
    private var _statsText : MaterialTextView? = null
    private var statsCircularProgressBar : CircularProgressBar? = null

    init {
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.StatsCardView, defStyleAttr, 0)
            setup(
                typedArray.getText(R.styleable.StatsCardView_title) ?: resources.getText(R.string.not_defined_label),
                typedArray.getBoolean(R.styleable.StatsCardView_withSubtitle, false),
                typedArray.getInt(R.styleable.StatsCardView_stats, _stats),
                defStyleAttr
            )
            typedArray.recycle()
        }

        ll.apply {
            orientation = LinearLayout.VERTICAL
            addView(_title, LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                this.gravity = Gravity.CENTER
            })
            _statsText?.let {
                addView(it, LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    this.gravity = Gravity.CENTER
                }) }
            statsCircularProgressBar?.let {
                addView(it, LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    this.gravity = Gravity.CENTER
                }) }
        }

        ll.setPadding(contentPaddingLeft, contentPaddingTop, contentPaddingRight, paddingBottom)
        setContentPadding(0,0,0,0)

        addView(ll, LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.WRAP_CONTENT
        ).apply {
            this.gravity = Gravity.CENTER
        })
    }

    protected fun setup(
        title : CharSequence,
        withSubtitle : Boolean = true,
        stats : Int? = null,
        defStyleAttr: Int = 0,
    ) {
        _title.text = title
        _title.textSize = 16f
        _title.typeface = Typeface.DEFAULT_BOLD
        if (withSubtitle) {
            _statsText = MaterialTextView(context, null, defStyleAttr)
            _statsText!!.text = resources.getText(R.string.not_defined_label)
            _statsText!!.textSize = 16f
        }else{
            statsCircularProgressBar = CircularProgressBar(context, null, defStyleAttr)
            statsCircularProgressBar!!.textSize = 20f
            trackThickness = resources.getDimensionPixelSize(R.dimen.stats_circular_track_thickness)
            indicatorSize = resources.getDimensionPixelSize(R.dimen.stats_circular_indicator_size)
        }
    }

    var title : CharSequence
        set(value) { _title.text = value }
        get() = _title.text

    var indicatorSize
        set(value) {
            value?.let {
                statsCircularProgressBar?.indicatorSize = value
            }
        }
        get() = statsCircularProgressBar?.indicatorSize

    var trackThickness
        set(value) {
            value?.let {
                statsCircularProgressBar?.trackThickness = value
            }
        }
        get() = statsCircularProgressBar?.trackThickness


    var stats : Int
        set(value) {
            _stats = value
            //Without subtitle
            statsCircularProgressBar?.progress = value

            //With subtitle
            statsText = subtitle()
            textColor(value)
        }
        get() = _stats


    protected abstract fun subtitle() : CharSequence?


    private var statsText
        set(value) {
            _statsText?.text = value
        }
        get() = _statsText?.text

    private fun textColor(value : Int) {
        when (value) {
            in 1..25 -> _statsText?.setTextColor(ResourcesCompat.getColor(resources, R.color.red, null))
            in 26..50 -> _statsText?.setTextColor(ResourcesCompat.getColor(resources, R.color.pink_500, null))
            in 51..75 -> _statsText?.setTextColor(ResourcesCompat.getColor(resources, R.color.blue_500, null))
            else -> _statsText?.setTextColor(ResourcesCompat.getColor(resources, R.color.light_green, null))
        }
    }

}