package com.esielkar.calificame.view

import android.content.Context
import android.util.AttributeSet
import com.esielkar.calificame.R
import com.esielkar.calificame.model.Difficulty

class ComplexityStatsCardView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : StatsCardView(context, attrs, defStyleAttr) {

    private var complexity : Difficulty

    init {
        title = "Complexity"
        complexity = when (stats){
            in 0..19 -> Difficulty.VERY_EASY
            in 20..39 -> Difficulty.EASY
            in 40..59 -> Difficulty.REGULAR
            in 60..79 -> Difficulty.HARD
            else -> Difficulty.VERY_HARD
        }
    }

    override fun subtitle() = when(complexity) {
        Difficulty.VERY_EASY -> resources.getTextArray(R.array.difficulty)[0]
        Difficulty.EASY -> resources.getTextArray(R.array.difficulty)[1]
        Difficulty.REGULAR -> resources.getTextArray(R.array.difficulty)[2]
        Difficulty.HARD -> resources.getTextArray(R.array.difficulty)[3]
        Difficulty.VERY_HARD -> resources.getTextArray(R.array.difficulty)[4]
    }
}