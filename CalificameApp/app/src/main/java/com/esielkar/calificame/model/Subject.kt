package com.esielkar.calificame.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Representa un materia de la aplicación Califícame!
 * @constructor Crea una nueva Materia dado su nombre
 * @property name Nombre de la materia
 */
data class Subject(val name : String) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()!!)

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Subject> {
        override fun createFromParcel(parcel: Parcel): Subject {
            return Subject(parcel)
        }

        override fun newArray(size: Int): Array<Subject?> {
            return arrayOfNulls(size)
        }
    }
}