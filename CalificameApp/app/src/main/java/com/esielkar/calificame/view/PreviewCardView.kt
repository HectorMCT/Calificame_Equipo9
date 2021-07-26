package com.esielkar.calificame.view

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.esielkar.calificame.R
import com.esielkar.calificame.utils.Utils
import com.google.android.material.card.MaterialCardView

class PreviewCardView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {

    private val rl  = RelativeLayout(this.context)
    private val ll  = LinearLayout(this.context).apply { this.orientation = LinearLayout.VERTICAL }
    private val trailingIcon =  ImageView(this.context)
    private val title = TextView(this.context)
    private val leadingDrawable : ImageView?
    private val subtitle : TextView?

    init {
        if (attrs != null) {
            val typedArray = context.obtainStyledAttributes(attrs, R.styleable.PreviewCardView, defStyleAttr, 0)

            val subtitle  = typedArray.getText(R.styleable.PreviewCardView_preview_card_subtitle)
            if (subtitle != null) {
                this.subtitle = TextView(this.context).apply {
                    this.text = subtitle
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                        this.setTextAppearance(R.style.TextAppearance_MaterialComponents_Subtitle1)
                    else
                        this.textSize = 16f
                }
            }else {
                this.subtitle = null
            }

            val title = typedArray.getText(R.styleable.PreviewCardView_preview_card_title) ?: resources.getText(R.string.not_defined_label)
            this.title.apply {
                this.text = title
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if (subtitle != null)
                        this.setTextAppearance(R.style.TextAppearance_MaterialComponents_Headline6)
                    else
                        this.setTextAppearance(R.style.TextAppearance_MaterialComponents_Headline5)

                } else
                    this.textSize = 24f
            }

            val drawable = typedArray.getDrawable(R.styleable.PreviewCardView_preview_card_leading_drawable)
            if (drawable != null) {
                this.leadingDrawable = ImageView(this.context).apply {
                    this.setImageDrawable(drawable)
                }
                this.leadingDrawable.id = View.generateViewId()

            }else
                leadingDrawable = null
            typedArray.recycle()
        }else{
            subtitle = null
            leadingDrawable = null
        }

        trailingIcon.apply {
            this.setImageResource(R.drawable.ic_outline_keyboard_arrow_right_24)
            this.id = View.generateViewId()
        }

        if (leadingDrawable != null){
            rl.addView(leadingDrawable, RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                this.addRule(RelativeLayout.ALIGN_PARENT_START)
                this.addRule(RelativeLayout.CENTER_VERTICAL)
            })
        }

        //Adding the LinearLayout
        rl.addView(
            ll.apply {
                this.layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                )
                this.addView(title)
                subtitle?.let { this.addView(it) }
            },
            RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                val padH = Utils.dpToPx(16, context)
                this.setMargins(padH, 0, padH, 0)
                this.addRule(RelativeLayout.CENTER_VERTICAL)
                this.addRule(RelativeLayout.START_OF, trailingIcon.id)
                if (leadingDrawable != null)
                    this.addRule(RelativeLayout.END_OF, this@PreviewCardView.leadingDrawable.id)
                else
                    this.addRule(RelativeLayout.ALIGN_PARENT_START)
            }
        )

        //Adding the Icon Button
        rl.addView(trailingIcon,
            RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                this.addRule(RelativeLayout.ALIGN_PARENT_END)
                this.addRule(RelativeLayout.CENTER_VERTICAL)
            }
        )
        rl.setPadding(contentPaddingLeft, contentPaddingTop, contentPaddingRight, paddingBottom)
        setContentPadding(0,0,0,0)

        addView(rl, RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        ))
    }
}