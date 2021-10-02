package com.esielkar.calificame.view.components

import android.content.Context
import android.util.AttributeSet
import com.esielkar.calificame.R
import com.google.android.material.card.MaterialCardView

abstract class CalificameCardView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {

    init {
        minimumHeight = resources.getDimensionPixelSize(R.dimen.min_card_height)
    }
}