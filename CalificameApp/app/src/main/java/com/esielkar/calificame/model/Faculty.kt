package com.esielkar.calificame.model

import android.os.Build

/**
 * Representa una facultad de la aplicación Califícame!
 * @constructor Crea una facultad dado su nombre
 * @property name Nombre de la facultad
 */
data class Faculty (val name : String) {
    private val _professors = mutableMapOf<Professor, ProfessorStats>()

    /**
     * @constructor Crea una facultad dado su nombre y un [Map] de [Professor] - [ProfessorStats].
     * @property name Nombre de la facultad
     * @property professors [Map] de los profesores con estadisticas de la facultad.
     */
    constructor(name : String, professors : Map<Professor, ProfessorStats>) : this(name) {
        _professors.putAll(professors)
    }

    val professors : Set<Professor>
    get() = _professors.map { it.key }.toSet()

    fun getStats(of : Professor) = _professors[of]

    /**
     * Añade el profesor dado a la facultad
     * @return `true` si el profesor se añadió, `false` si ya existía.
     */
    fun add(professor : Professor) = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        _professors.putIfAbsent(professor, ProfessorStats(0.0,0.0, 0.0))
    } else {
        if ( _professors[professor] == null) _professors.put(professor, ProfessorStats(0.0,0.0, 0.0))
        else null
    }

    /**
     * Elimina el profesor de la facultad
     * @return true si la profesor se eliminó, false si no exististe el la facultad.
     */
    fun remove(professor : Professor) = _professors.remove(professor)

    fun getProfessorsWithStatsAndReviewsCounts() = professors.map {
        val counters = getStats(it)?.getStatsAndReviewsCounts()
        Triple<Professor, Int, Int>(it, counters?.first ?: 0, counters?.second ?: 0)
    }
}