package com.esielkar.calificame.objects

import com.google.gson.annotations.SerializedName

data class UniContent(
    @SerializedName("Items")
    val items: List<UniItem>? = null
)