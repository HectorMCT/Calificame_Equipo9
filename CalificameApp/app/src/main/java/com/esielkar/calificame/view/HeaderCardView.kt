package com.esielkar.calificame.view

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.res.ResourcesCompat
import com.esielkar.calificame.R
import com.esielkar.calificame.utils.Utils

class HeaderCardView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {

    private val ll  = LinearLayout(this.context)
    private val title = TextView(this.context)
    private val subtitle : TextView?
    private val caption : TextView?

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

            val caption  = typedArray.getText(R.styleable.HeaderCardView_header_card_caption)
            if (caption != null) {
                this.caption = TextView(this.context).apply {
                    this.text = caption.toString().uppercase()
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        this.setTextAppearance(R.style.TextAppearance_MaterialComponents_Overline)
                    }else{
                        this.textSize = 12f
                    }
                    this.setTextColor(ResourcesCompat.getColor(resources, R.color.white, null))
                }
            }else this.caption = null
            typedArray.recycle()
        }else{
            subtitle = null
            caption = null
        }


        ll.apply {
            this.background = ResourcesCompat.getDrawable(resources, R.drawable.gradient_background, null)
            this.orientation = LinearLayout.VERTICAL

            val padV = Utils.dpToPx(8, context)
            val padH = Utils.dpToPx(16, context)

            setPadding(padH,padV,padH,padV)
            addView(title)
            subtitle?.let {
                addView(it) }
            caption?.let {
                addView(it) }
        }

        addView(ll, LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        ))
    }
}