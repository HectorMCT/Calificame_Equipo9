package com.esielkar.calificame.view.components

import android.content.Context
import android.util.AttributeSet
import com.esielkar.calificame.R
import com.esielkar.calificame.model.Score

class DomainStatsCardView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : StatsCardView(context, attrs, defStyleAttr) {

    private var domain : Score

    init {
        title = resources.getString(R.string.label_domain)
        domain = when (stats){
            in 0..19 -> Score.TERRIBLE
            in 20..39 -> Score.BAD
            in 40..59 -> Score.REGULAR
            in 60..79 -> Score.GOOD
            else -> Score.EXCELLENT
        }
    }

    override fun subtitle() = when(domain) {
        Score.EXCELLENT -> resources.getTextArray(R.array.score)[0]
        Score.GOOD -> resources.getTextArray(R.array.score)[1]
        Score.REGULAR -> resources.getTextArray(R.array.score)[2]
        Score.BAD -> resources.getTextArray(R.array.score)[3]
        Score.TERRIBLE -> resources.getTextArray(R.array.score)[4]
    }

}