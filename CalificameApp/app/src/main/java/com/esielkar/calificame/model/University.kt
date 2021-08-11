package com.esielkar.calificame.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Representa una universidad de la aplicación Califícame!
 * *@constructor Crea una universidad dado su nombre y (opcionalmente)
 */
data class University (val name : String) : Parcelable{
    private var _faculties = mutableSetOf<Faculty>()
    /**
     *@constructor Crea una universidad dado su nombre y un [Set] de facultades.
     * @property name Nombre de la universidad
     * @property faculties Set de las facultades de la universidad
     */
    constructor(name : String, faculties : Set<Faculty>) : this(name) {
        _faculties.addAll(faculties)
    }

    constructor(parcel: Parcel) : this(parcel.readString()!!) {
        _faculties = readParcelableSet(parcel, 0)
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
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        writeParcelableSet(parcel, flags, _faculties)
    }

    private fun <E : Parcelable> writeParcelableSet(
        parcel : Parcel, flags : Int, set : Set<E>) {
        parcel.writeInt(set.size)
        set.forEach {
            parcel.writeParcelable(it, flags)
        }
    }

    private inline fun <reified E : Parcelable> readParcelableSet(
        parcel : Parcel, flags : Int) : MutableSet<E> {
        val set = mutableSetOf<E>()
        for (i in 1..parcel.readInt()){
            val item = parcel.readParcelable<E>(E::class.java.classLoader)
            set.add(item!!)
        }
        return set
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<University> {
        override fun createFromParcel(parcel: Parcel): University {
            return University(parcel)
        }

        override fun newArray(size: Int): Array<University?> {
            return arrayOfNulls(size)
        }
    }
}
