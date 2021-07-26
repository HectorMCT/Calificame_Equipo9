package com.esielkar.calificame.utils

import android.content.Context


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