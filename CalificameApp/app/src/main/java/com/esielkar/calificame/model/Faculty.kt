package com.esielkar.calificame.model

import android.os.Build
import android.os.Parcel
import android.os.Parcelable

/**
 * Representa una facultad de la aplicación Califícame!
 * @constructor Crea una facultad dado su nombre
 * @property name Nombre de la facultad
 */
data class Faculty (val name : String) : Parcelable{
    private var _professors = mutableMapOf<Professor, ProfessorStats>()

    /**
     * @constructor Crea una facultad dado su nombre y un [Map] de [Professor] - [ProfessorStats].
     * @property name Nombre de la facultad
     * @property professors [Map] de los profesores con estadisticas de la facultad.
     */
    constructor(name : String, professors : Map<Professor, ProfessorStats>) : this(name) {
        _professors.putAll(professors)
    }

    constructor(parcel: Parcel) : this(parcel.readString()!!) {
        _professors = readParcelableMap(parcel, 0)
    }

    val professors : Set<Professor>
        get() = _professors.map { it.key }.toSet()

    fun getStats(of : Professor) = _professors[of]

    /**
     * Añade el profesor dado a la facultad
     * @return `true` si el profesor se añadió, `false` si ya existía.
     */
    fun add(professor : Professor) = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        _professors.putIfAbsent(professor, ProfessorStats())
    } else {
        if (_professors[professor] == null)
            _professors.put(professor, ProfessorStats())
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

    private fun <K : Parcelable, V : Parcelable> writeParcelableMap(
        parcel : Parcel, flags : Int, map : Map<K, V>) {
        parcel.writeInt(map.size)
        map.entries.forEach { entry ->
            parcel.writeParcelable(entry.key, flags)
            parcel.writeParcelable(entry.value, flags)
        }
    }

    private inline fun <reified K : Parcelable, reified V : Parcelable> readParcelableMap(
        parcel : Parcel, flags : Int) : MutableMap<K, V> {
        val map = mutableMapOf<K, V>()
        for (i in 1..parcel.readInt()){
            val key = parcel.readParcelable<K>(K::class.java.classLoader)
            val value = parcel.readParcelable<V>(V::class.java.classLoader)
            map.put(key!!, value!!)
        }
        return map
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        writeParcelableMap(parcel, flags, _professors)
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<Faculty> {
        override fun createFromParcel(parcel: Parcel): Faculty {
            return Faculty(parcel)
        }

        override fun newArray(size: Int): Array<Faculty?> {
            return arrayOfNulls(size)
        }
    }
}