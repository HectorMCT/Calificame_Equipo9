package com.esielkar.calificame.objects

import com.google.gson.annotations.SerializedName

data class UniItem (
    @SerializedName("imagen_uni")
    val thumbnail: String? = null,

    @SerializedName("uni_name")
    val title: String? = null
)