package com.esielkar.calificame.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Representa un usuario de la aplicación Califícame!
 * @constructor Crea un nuevo User dado su nombre y su contraseña
 * @property username Nombre de usuario
 * @property email Nombre de usuario
 * @property password Contraseña
 */
data class User(val username : String, val email : String,  val password : String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(username)
        parcel.writeString(email)
        parcel.writeString(password)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}