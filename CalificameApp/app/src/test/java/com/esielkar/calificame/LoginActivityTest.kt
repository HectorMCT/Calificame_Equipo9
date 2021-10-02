package com.esielkar.calificame

import com.esielkar.calificame.model.User
import com.esielkar.calificame.placeholder.UsersContent.validUser
import com.esielkar.calificame.placeholder.UsersContent.validUsername
import org.junit.Test
import com.google.common.truth.Truth.assertThat

import org.junit.Assert.*

class LoginActivityTest {

    @Test
    fun testValidUsername() {
        //GIVEN
        val users = "Hector"
        //when
        val result = validUsername(users)
        //then
        assertEquals(false, result)
    }

    @Test
    fun testAssertValidUsername() {
        //GIVEN
        val users = "Hector"
        //when
        val result = validUsername(users)
        //then
        assertThat(result).isFalse()
    }

    @Test
    fun testValidUser() {
        //GIVEN
        val pass = "12345678"
        val email = "hector@calificame.com"
        //when
        val result = validUser(email, pass)
        //then
        assertEquals(User("Hector", "hector@calificame.com", "12345678"), result)
    }

    @Test
    fun testAssertValidUser() {
        //GIVEN
        val pass = "12345678"
        val email = "hector@calificame.com"
        //when
        val result = validUser(email, pass)
        //then
        assertThat(result)
    }

    @Test
    fun testFalseValidUser() {
        //GIVEN
        val pass = ""
        val email = ""
        //when
        val result = validUser(email, pass)
        //then
        assertEquals(User("Invitado", "", ""), result)
    }

}