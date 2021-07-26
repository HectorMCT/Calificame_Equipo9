package com.esielkar.calificame.view

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.esielkar.calificame.R
import com.google.android.material.card.MaterialCardView

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
) : MaterialCardView(context, attrs, defStyleAttr) {

    private val ll  = LinearLayout(this.context)
    private val title = TextView(this.context)
    private val subtitle : TextView?
    private val overline : TextView?

    init {
        if (attrs != null) {
            val typedArray = context.obtainStyledAttributes(attrs, R.styleable.HeaderCardView, defStyleAttr, 0)
            val title = typedArray.getText(R.styleable.HeaderCardView_header_card_title) ?: resources.getText(R.string.not_defined_label)
            this.title.apply {
                this.text = title
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    this.setTextAppearance(R.style.TextAppearance_MaterialComponents_Headline5)
                }else
                    this.textSize = 24f
                this.setTextColor(ResourcesCompat.getColor(resources, R.color.white, null))
            }

            val subtitle  = typedArray.getText(R.styleable.HeaderCardView_header_card_subtitle)
            if (subtitle != null) {
                this.subtitle = TextView(this.context).apply {
                    this.text = subtitle
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        this.setTextAppearance(R.style.TextAppearance_MaterialComponents_Subtitle1)
                    }else
                        this.textSize = 20f
                    this.setTextColor(ResourcesCompat.getColor(resources, R.color.white, null))
                }
            }else this.subtitle = null

            val overline  = typedArray.getText(R.styleable.HeaderCardView_header_card_overline)
            if (overline != null) {
                this.overline = TextView(this.context).apply {
                    this.text = overline.toString().uppercase()
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        this.setTextAppearance(R.style.TextAppearance_MaterialComponents_Overline)
                    }else{
                        this.textSize = 12f
                    }
                    this.setTextColor(ResourcesCompat.getColor(resources, R.color.white, null))
                }
            }else this.overline = null
            typedArray.recycle()
        }else{
            subtitle = null
            overline = null
        }


        ll.apply {
            this.background = ResourcesCompat.getDrawable(resources, R.drawable.gradient_background, null)
            this.orientation = LinearLayout.VERTICAL
            addView(title)
            subtitle?.let {
                addView(it) }
            overline?.let {
                addView(it) }
        }

        ll.setPadding(contentPaddingLeft, contentPaddingTop, contentPaddingRight, paddingBottom)
        setContentPadding(0,0,0,0)

        addView(ll, LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        ))
    }
}