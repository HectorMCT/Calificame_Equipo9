package com.esielkar.calificame.model

/**
 * Representa un usuario de la aplicación Califícame!
 * @constructor Crea un nuevo User dado su nombre y su contraseña
 * @property username Nombre de usuario
 * @property email Nombre de usuario
 * @property password Contraseña
 */
data class User(val username : String, val email : String,  val password : String)