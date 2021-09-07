package com.esielkar.calificame.objects

import com.google.gson.annotations.SerializedName

data class UniResponse (
    @SerializedName("unis")
    val uniList: UniContent? = null
)