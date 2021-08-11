package com.esielkar.calificame.view.adapter

import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.updateLayoutParams
import com.esielkar.calificame.R
import com.esielkar.calificame.utils.Utils
import com.google.android.material.card.MaterialCardView

//TODO: E : Parcelable
sealed class CardViewAdapter<E, V : MaterialCardView> (
    items : Collection<E>,
    onItemClickListener : View.OnClickListener? = null,
    onItemLongClickListener : View.OnLongClickListener? = null
) : BindableAdapter<E>(items, onItemClickListener, onItemLongClickListener) {
    fun applyStyle(cardView : V) = cardView.apply {
            strokeWidth = Utils.dpToPx(1, context)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                strokeColor = resources.getColor(R.color.blue_500, null)
            }
            cardElevation = Utils.dpToPx(8f, context)
            radius = Utils.dpToPx(8f, context = context)
        }
}