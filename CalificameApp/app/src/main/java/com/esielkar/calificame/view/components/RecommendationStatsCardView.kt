package com.esielkar.calificame.view.components

import android.content.Context
import android.util.AttributeSet
import com.esielkar.calificame.R
import com.esielkar.calificame.model.YesNo

class RecommendationStatsCardView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : StatsCardView(context, attrs, defStyleAttr) {

    private var recommendation : YesNo

    init {
        title = resources.getString(R.string.label_recommendation)

        recommendation = when (stats) {
            0 -> YesNo.NO
            else -> YesNo.YES
        }
    }

    override fun subtitle(): CharSequence? = when(recommendation){
        YesNo.YES -> resources.getTextArray(R.array.YesNo)[0]
        YesNo.NO -> resources.getTextArray(R.array.YesNo)[1]
    }

}