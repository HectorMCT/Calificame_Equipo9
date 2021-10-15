package com.esielkar.calificame.utils

import android.view.View
import com.google.android.material.snackbar.Snackbar

object UIUtils {

    fun showSnackbar(view: View, textId: Int, actionTextId: Int ){
        Snackbar.make(
            view,
            textId,
            Snackbar.LENGTH_LONG
        ).setAction(actionTextId){ }.show()
    }

}