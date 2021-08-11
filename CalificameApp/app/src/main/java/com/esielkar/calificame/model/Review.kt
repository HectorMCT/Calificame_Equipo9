package com.esielkar.calificame.model

import android.os.Parcel
import android.os.Parcelable
import java.util.Date

/**
 * Representa una review de la aplicación Califícame!
 * @constructor Crea una nueva reseña dado un [User], comment y satisfaction
 * @property user Usuario que hace la review
 * @property date fecha en la que se hace la review (Por defecto es la actual cuando se crea)
 * @property comment Comentario que hace el usuario
 * @property satisfaction Grado de satisfaction del usuario
 */
data class Review (
    val user : User,
    val comment : String,
    val satisfaction : Double,
    private val date : Date = Date()
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(User::class.java.classLoader)!!,
        parcel.readString()!!,
        parcel.readDouble(),
        parcel.readSerializable() as Date)

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(user, flags)
        parcel.writeString(comment)
        parcel.writeDouble(satisfaction)
        parcel.writeSerializable(date)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Review> {
        override fun createFromParcel(parcel: Parcel): Review {
            return Review(parcel)
        }

        override fun newArray(size: Int): Array<Review?> {
            return arrayOfNulls(size)
        }
    }
}
