package com.esielkar.calificame.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import com.esielkar.calificame.R
import com.google.android.material.card.MaterialCardView

class SignatureCardView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {
    private val signatureNameTextView : TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.signature_card_view, this, true)
        signatureNameTextView = findViewById(R.id.signature_name)

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.SignatureCardView, defStyleAttr, 0)
            val signatureName = typedArray.getText(R.styleable.SignatureCardView_signature_name) ?: resources.getText(R.string.not_defined_label)
            this.signatureName = signatureName
            typedArray.recycle()
        }
    }

    var signatureName : CharSequence
    set(value) {signatureNameTextView.text = value}
    get() = signatureNameTextView.text
}