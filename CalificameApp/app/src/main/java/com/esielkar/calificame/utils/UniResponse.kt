package com.esielkar.calificame.utils

import com.google.gson.annotations.SerializedName

data class UniResponse (
    @SerializedName("unis")
    val uniList: UniContent? = null
)