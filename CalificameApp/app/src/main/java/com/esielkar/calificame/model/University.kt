package com.esielkar.calificame.model

/**
 * Representa una universidad de la aplicación Califícame!
 * *@constructor Crea una universidad dado su nombre y (opcionalmente)
 */
data class University (val name : String){
    private val _faculties = mutableSetOf<Faculty>()
    /**
     *@constructor Crea una universidad dado su nombre y un [Set] de facultades.
     * @property name Nombre de la universidad
     * @property faculties Set de las facultades de la universidad
     */
    constructor(name : String, faculties : Set<Faculty>) : this(name) {
        _faculties.addAll(faculties)
    }

    val faculties : Set<Faculty>
        get() = _faculties.toSet()

    /**
     * Añade la facultad dada a la universidad
     * @return `true` si la facultad se añadió, `false` si ya existía.
     */
    fun add(faculty : Faculty) = _faculties.add(faculty)

    /**
     * Elimina la facultad dada de la universidad
     * @return `true` si la facultad se eliminó, `false` si no exististe en la universidad.
     */
    fun remove(faculty : Faculty) = _faculties.remove(faculty)
}
