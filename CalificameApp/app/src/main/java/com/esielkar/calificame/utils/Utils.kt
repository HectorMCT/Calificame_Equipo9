package com.esielkar.calificame.utils

import android.content.Context
import com.esielkar.calificame.model.Professor
import com.esielkar.calificame.model.Subject

/**
 * first: [Subject] subject
 * second: stats count
 * third: reviews count
 */
typealias SubjectWithInfo = Triple<Subject, Int, Int>

/**
 * first: [Professor] professor
 * second: stats count
 * third: reviews count
 */
typealias ProfessorWithInfo = Triple<Professor, Int, Int>

/**
 * first: stats count
 * second: reviews count
 */
typealias StatsAndReviews = Pair<Int, Int>

class Utils {
    companion object{
        fun dpToPx(dp: Float, context: Context): Float {
            return dp * context.resources.displayMetrics.density
        }

        fun pxToDp(px: Float, context: Context): Float {
            return px / context.resources.displayMetrics.density
        }

        fun dpToPx(dp: Int, context: Context): Int {
            return (dp * context.resources.displayMetrics.density).toInt()
        }

        fun pxToDp(px: Int, context: Context): Int {
            return (px / context.resources.displayMetrics.density).toInt()
        }
    }
}