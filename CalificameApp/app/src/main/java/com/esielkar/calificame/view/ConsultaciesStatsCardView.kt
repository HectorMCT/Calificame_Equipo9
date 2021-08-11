package com.esielkar.calificame.view

import android.content.Context
import android.util.AttributeSet
import com.esielkar.calificame.R
import com.esielkar.calificame.model.Frecuency

class ConsultanciesStatsCardView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : StatsCardView(context, attrs, defStyleAttr) {

    private var consultancies : Frecuency
    init {
        title = "Consultancies"

        consultancies = when (stats) {
            in 0..33 -> Frecuency.NEVER
            in 33..66 -> Frecuency.SOMETIMES
            else -> Frecuency.ALWAYS

        }
    }

    override fun subtitle(): CharSequence? = when (consultancies) {
        Frecuency.ALWAYS -> resources.getTextArray(R.array.frecuency)[0]
        Frecuency.SOMETIMES -> resources.getTextArray(R.array.frecuency)[1]
        Frecuency.NEVER -> resources.getTextArray(R.array.frecuency)[2]
    }

}