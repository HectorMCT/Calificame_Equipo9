package com.esielkar.calificame.utils

import com.google.gson.annotations.SerializedName

data class UniContent(
    @SerializedName("Items")
    val items: List<UniItem>? = null
)