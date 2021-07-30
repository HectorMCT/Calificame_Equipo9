package com.esielkar.calificame.model.adapter

import android.os.Build
import com.esielkar.calificame.R
import com.esielkar.calificame.utils.Utils
import com.google.android.material.card.MaterialCardView

//TODO: E : Parceable
abstract class CardViewAdapter<E, V : MaterialCardView> (
    items : Collection<E>,
    onItemClickListener : ((E) -> Unit)? = null
) : BindableAdapter<E>(items, onItemClickListener) {
    fun applyStyle(cardView : V) = cardView.apply {
            strokeWidth = Utils.dpToPx(1, context)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                strokeColor = resources.getColor(R.color.blue_500, null)
            }
            cardElevation = Utils.dpToPx(8f, context)
            radius = Utils.dpToPx(8f, context = context)
        }

}