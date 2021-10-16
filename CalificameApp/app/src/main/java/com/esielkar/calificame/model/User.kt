package com.esielkar.calificame.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

/**
 * Representa un usuario de la aplicación Califícame!
 * @constructor Crea un nuevo User dado su nombre y su contraseña
 * @property username Nombre de usuario
 * @property email Nombre de usuario
 * @property password Contraseña
 */

@Parcelize
data class User(
    val username : String,
    val email : String) : Parcelable