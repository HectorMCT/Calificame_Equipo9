package com.esielkar.calificame.view.components

import android.content.Context
import android.util.AttributeSet
import com.esielkar.calificame.R
import com.esielkar.calificame.model.Frecuency

class FairEvaluationStatsCardView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : StatsCardView(context, attrs, defStyleAttr) {

    private var fairEvaluation : Frecuency

    init {
        title = "Fair Evaluation"

        fairEvaluation = when (stats) {
            in 0..33 -> Frecuency.NEVER
            in 33..66 -> Frecuency.SOMETIMES
            else -> Frecuency.ALWAYS

        }
    }

    override fun subtitle(): CharSequence? = when (fairEvaluation) {
        Frecuency.ALWAYS -> resources.getTextArray(R.array.frecuency)[0]
        Frecuency.SOMETIMES -> resources.getTextArray(R.array.frecuency)[1]
        Frecuency.NEVER -> resources.getTextArray(R.array.frecuency)[2]
    }

}