package com.esielkar.calificame.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.View
import com.esielkar.calificame.R
import com.google.android.material.snackbar.Snackbar
import es.dmoral.toasty.Toasty

const val ERROR = "error"
const val SUCCESS = "success"
const val INFO = "info"
const val INFO_FORMATTED = "info_formatted"
const val WARNING = "warning"
const val NORMAL = "normal"
const val NORMAL_WITH_ICON = "normalWithIcon"
const val CUSTOM = "custom"

fun showToasty(
    context: Context,
    type: String,
    message: String,
    duration: Int,
    withIcon: Boolean,
    drawable: Drawable?,
    charSequence: CharSequence?
) {
    when (type) {
        "error" -> Toasty.error(context, message, duration, withIcon).show()
        "success" -> Toasty.success(context, message, duration, withIcon).show()
        "info" -> Toasty.info(context, message, duration, withIcon).show()
        "info_formatted" -> charSequence?.let { Toasty.info(context, it).show() }
        "warning" -> Toasty.warning(context, message, duration, withIcon).show()
        "normal" -> Toasty.normal(context, message, duration).show()
        "normalWithIcon" -> Toasty.normal(context, message, duration, drawable).show()
        "custom" -> if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Toasty.custom(
                context,
                message,
                drawable,
                context.resources.getColor(R.color.blue_500, context.theme),
                context.resources.getColor(R.color.pink_200, context.theme),
                duration,
                true,
                true
            ).show()
        } else {
            Toasty.custom(
                context,
                message,
                drawable,
                context.resources.getColor(R.color.blue_500),
                context.resources.getColor(R.color.pink_200),
                duration,
                true,
                true
            ).show()
        }
    }
}

fun showSnackbar(view: View, textId: Int, actionTextId: Int ){
    Snackbar.make(
        view,
        textId,
        Snackbar.LENGTH_LONG
    ).setAction(actionTextId){ }.show()
}