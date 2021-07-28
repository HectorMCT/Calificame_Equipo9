package com.esielkar.calificame.model

/**
 * Clase abstracta que representa las estadisticas en común de un profesor y una materia
 * @throws StatsOutOfRangeException si facility, clarity o recommendation no están en el rango de valores de 1 - 100.
 */
abstract class Stats(var facility: Double = 0.0, var clarity: Double = 0.0, var recommendation: Double = 0.0) {
    init {
        val range = 0.0..100.0
        when {
            facility !in range -> throw StatsOutOfRangeException("Facility out of range. Range: from 0 up to 100")
            clarity !in range -> throw StatsOutOfRangeException("Clarity out of range. Range: from 0 up to 100")
            recommendation !in range -> throw StatsOutOfRangeException("Recommendation out of range. Range: from 0 up to 100")
        }
    }
}