package com.esielkar.calificame.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Clase sellada que representa las estadisticas en común de un profesor y una materia
 * @throws StatsOutOfRangeException si facility, clarity o recommendation no están en el rango de valores de 1 - 100.
 */
sealed class Stats(
    var facility: Double = 0.0,
    var clarity: Double = 0.0,
    var recommendation: Double = 0.0
) : Parcelable {
    init {
        val range = 0.0..100.0
        when {
            facility !in range -> throw StatsOutOfRangeException("Facility out of range. Range: from 0 up to 100")
            clarity !in range -> throw StatsOutOfRangeException("Clarity out of range. Range: from 0 up to 100")
            recommendation !in range -> throw StatsOutOfRangeException("Recommendation out of range. Range: from 0 up to 100")
        }
    }

    override fun describeContents() = 0
    override fun writeToParcel(parcel : Parcel, flags: Int) {
        parcel.writeDouble(facility)
        parcel.writeDouble(clarity)
        parcel.writeDouble(recommendation)
    }
}