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

open class StatsCardView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : CalificameCardView(context, attrs, defStyleAttr) {

    private val ll = LinearLayout(context)
    private val _title : MaterialTextView = MaterialTextView(context, null, defStyleAttr)
    private var _stats = 0
    protected var _statsText : MaterialTextView? = null
    protected var statsCircularProgressBar : CircularProgressBar? = null

    constructor(
        context: Context,
        defStyleAttr: Int = 0,
        title : String,
        subtitle : String? = null,
        withSubtitle : Boolean = true,
        stats : Int? = null,
    ) : this(context, null, defStyleAttr) {
        setup(title, subtitle, withSubtitle, stats, defStyleAttr)
    }

    init {
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.StatsCardView, defStyleAttr, 0)
            setup(
                typedArray.getText(R.styleable.StatsCardView_title) ?: resources.getText(R.string.not_defined_label),
                typedArray.getText(R.styleable.StatsCardView_subtitle),
                typedArray.getBoolean(R.styleable.StatsCardView_withSubtitle, false),
                typedArray.getInt(R.styleable.StatsCardView_stats, _stats),
                defStyleAttr
            )
            /*title = typedArray.getText(R.styleable.StatsCardView_title) ?: resources.getText(R.string.not_defined_label)
            _title.textSize = 20f
            if (typedArray.getBoolean(R.styleable.StatsCardView_withSubtitle, false)) {
                _statsText = MaterialTextView(context, null, defStyleAttr)
                _statsText!!.textSize = 20f
            }else {
                statsCircularProgressBar = CircularProgressBar(context, null, defStyleAttr)
                statsCircularProgressBar!!.textSize = 20f
                trackThickness = resources.getDimensionPixelSize(R.dimen.stats_circular_track_thickness)
                indicatorSize = resources.getDimensionPixelSize(R.dimen.stats_circular_indicator_size)
                stats = typedArray.getInt(R.styleable.StatsCardView_stats, _stats)
            }*/
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
        subtitle : CharSequence? = null,
        withSubtitle : Boolean = true,
        stats : Int? = null,
        defStyleAttr: Int = 0,
    ) {
        _title.text = title
        _title.textSize = 20f
        _title.typeface = Typeface.DEFAULT_BOLD
        if (withSubtitle) {
            _statsText = MaterialTextView(context, null, defStyleAttr)
            _statsText!!.text = subtitle ?: resources.getText(R.string.not_defined_label)
            _statsText!!.textSize = 20f
        }else{
            statsCircularProgressBar = CircularProgressBar(context, null, defStyleAttr)
            statsCircularProgressBar!!.textSize = 20f
            trackThickness = resources.getDimensionPixelSize(R.dimen.stats_circular_track_thickness)
            indicatorSize = resources.getDimensionPixelSize(R.dimen.stats_circular_indicator_size)
            this.stats = stats ?: _stats
        }
    }

    var title : CharSequence
        set(value) { _title.text = value }
        get() = _title.text

    var statsText
        set(value) {
            _statsText?.text = value
        }
        get() = _statsText?.text

    protected var statsTextColor : Int?
        set(@ColorInt value) {
            if (value != null) {
                _statsText?.setTextColor(value)
            }
        }
        get() = _statsText?.currentTextColor

    var stats : Int
        set(value) {
            _stats = value
            statsCircularProgressBar?.progress = value
        }
        get() = _stats

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

    protected fun textColor(value : Int) {
        when (value) {
            in 1..25 -> _statsText!!.setTextColor(ResourcesCompat.getColor(resources, R.color.light_yellow, null))
            in 26..50 -> _statsText!!.setTextColor(ResourcesCompat.getColor(resources, R.color.light_orange, null))
            in 51..75 -> _statsText!!.setTextColor(ResourcesCompat.getColor(resources, R.color.light_blue, null))
            else -> _statsText!!.setTextColor(ResourcesCompat.getColor(resources, R.color.light_green, null))
        }
    }

}