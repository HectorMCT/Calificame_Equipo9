package com.esielkar.calificame.view.components

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.esielkar.calificame.R

/**
 * A custom CardView with a <code>Gradient</code>, title, subtitle and overline.
 * The <code>background</code> of this Card is a <code>Gradient</code>
 *
 * @attr ref com.esielkar.R.stylable#HeaderCardView_header_card_title
 * @attr ref com.esielkar.R.stylable#HeaderCardView_header_card_subtitle
 * @attr ref com.esielkar.R.stylable#HeaderCardView_header_card_overline
 */
class HeaderCardView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : CalificameCardView(context, attrs, defStyleAttr) {

    private val ll  = LinearLayout(this.context)
    private val titleTextView = TextView(this.context)
    private var subtitleTextView : TextView? = null
    private var overlineTextView : TextView? = null

    init {
        if (attrs != null) {
            val typedArray = context.obtainStyledAttributes(attrs, R.styleable.HeaderCardView, defStyleAttr, 0)
            val title = typedArray.getText(R.styleable.HeaderCardView_header_card_title) ?: resources.getText(R.string.not_defined_label)
            this.titleTextView.apply {
                this.text = title
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    this.setTextAppearance(R.style.TextAppearance_MaterialComponents_Headline5)
                }else
                    this.textSize = 24f
                this.setTextColor(ResourcesCompat.getColor(resources, R.color.white, null))
            }

            val subtitle  = typedArray.getText(R.styleable.HeaderCardView_header_card_subtitle)
            if (subtitle != null) createSubtitleTextView(subtitle)
            else this.subtitleTextView = null

            val overline  = typedArray.getText(R.styleable.HeaderCardView_header_card_overline)
            if (overline != null) createOverlineTextView(overline)
            else this.overlineTextView = null
            typedArray.recycle()
        }else{
            subtitleTextView = null
            overlineTextView = null
        }


        ll.apply {
            this.background = ResourcesCompat.getDrawable(resources, R.drawable.gradient_background, null)
            this.orientation = LinearLayout.VERTICAL
            addView(titleTextView)
            subtitleTextView?.let {
                addView(it) }
            overlineTextView?.let {
                addView(it) }
        }

        ll.setPadding(contentPaddingLeft, contentPaddingTop, contentPaddingRight, paddingBottom)
        setContentPadding(0,0,0,0)

        addView(ll, LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        ))
    }

    var title: CharSequence
        set(value) {titleTextView.text = value}
        get() = titleTextView.text

    var subtitle
        set(value) {
            if (subtitleTextView != null)
                subtitleTextView!!.text = value
            else value?.let {
                createSubtitleTextView(value)
                if (overlineTextView != null) {
                    overlineTextView.let {
                        this.removeView(it)
                        this.addView(subtitleTextView)
                        this.addView(it)
                    }
                } else ll.addView(subtitleTextView)
            }
        }
        get() = subtitleTextView?.text

    var overline
        set(value) {
            if (overlineTextView != null)
                overlineTextView!!.text = value
            else value?.let {
                createOverlineTextView(value)
                ll.addView(overlineTextView)
            }
        }
        get() = overlineTextView?.text


    private fun createSubtitleTextView(value: CharSequence) {
        this.subtitleTextView = TextView(this.context).apply {
            this.text = value
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                this.setTextAppearance(R.style.TextAppearance_MaterialComponents_Subtitle1)
            }else
                this.textSize = 20f
            this.setTextColor(ResourcesCompat.getColor(resources, R.color.white, null))
        }
    }

    private fun createOverlineTextView(value : CharSequence) {
        this.overlineTextView = TextView(this.context).apply {
            this.text = value.toString().uppercase()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                this.setTextAppearance(R.style.TextAppearance_MaterialComponents_Overline)
            }else{
                this.textSize = 12f
            }
            this.setTextColor(ResourcesCompat.getColor(resources, R.color.white, null))
        }
    }


}