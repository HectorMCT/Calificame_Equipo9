package com.esielkar.calificame.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Representa un profesor de la aplicación Califícame!
 * @constructor Crea un nuevo profesor dado su nombre
 * @property name Nombre del profesor
 */
data class Professor(val name : String) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()!!)

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Professor> {
        override fun createFromParcel(parcel: Parcel): Professor {
            return Professor(parcel)
        }

        override fun newArray(size: Int): Array<Professor?> {
            return arrayOfNulls(size)
        }
    }
}