package com.esielkar.calificame.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Representa las estisticas de una materia de la aplicación Califícame!
 * @constructor Crea las estadisticas de una materia dadas la facilidad, claridad, recomendación
 * dominio, complejidad, evaluación justa, si aplica examenes y la cantidad de examenes
 * @throws StatsOutOfRangeException si facility, clarity, recommendation, domain, complexity
 * fairEvaluation, applyExams, no están en el rango de valores de 1 - 100.
 */
class SubjectStats//Range
    (facility: Double = 0.0,
     clarity: Double = 0.0,
     recommendation: Double = 0.0,//Stats
     var domain: Double = 0.0,
     var complexity: Double = 0.0,
     var fairEvaluation: Double = 0.0,
     var consultancies: Double = 0.0,
     var applyExams: Double = 0.0,
     var examsCount: Int = 0
) : Stats(facility, clarity, recommendation) {

    constructor(parcel: Parcel) : this(
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readInt()
    )

    init {
        val range = 0.0..100.0 //Range
        when {
            domain !in range -> throw StatsOutOfRangeException("Domain out of range. Range: from 0 up to 100")
            complexity !in range -> throw StatsOutOfRangeException("Complexity out of range. Range: from 0 up to 100")
            fairEvaluation !in range -> throw StatsOutOfRangeException("Fair Evaluation out of range. Range: from 0 up to 100")
            consultancies !in range -> throw StatsOutOfRangeException("Consultancies out of range. Range: from 0 up to 100")
            applyExams !in range -> throw StatsOutOfRangeException("Apply Exams out of range. Range: from 0 up to 100")
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        super.writeToParcel(parcel, flags)
        parcel.writeDouble(domain)
        parcel.writeDouble(complexity)
        parcel.writeDouble(fairEvaluation)
        parcel.writeDouble(consultancies)
        parcel.writeDouble(applyExams)
        parcel.writeInt(examsCount)
    }

    companion object CREATOR : Parcelable.Creator<SubjectStats> {
        override fun createFromParcel(parcel: Parcel): SubjectStats {
            return SubjectStats(parcel)
        }

        override fun newArray(size: Int): Array<SubjectStats?> {
            return arrayOfNulls(size)
        }
    }
}