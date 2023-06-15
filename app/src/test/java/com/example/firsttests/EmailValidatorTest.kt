package com.example.firsttests

import com.example.firsttests.domain.EmailValidator
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class EmailValidatorTest {

    private lateinit var emailValidator: EmailValidator

    @Before
    fun setup(){
        emailValidator = EmailValidator()
    }

    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertTrue(emailValidator.isValidEmail("Anton-Tchaikovsky@yandex.by"))
    }

    @Test
    fun emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        assertTrue(emailValidator.isValidEmail("name@email.co.uk"))
    }

    @Test
    fun emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        assertFalse(emailValidator.isValidEmail("name@email"))
    }

    @Test
    fun emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        assertFalse(emailValidator.isValidEmail("name@email..com"))
    }

    @Test
    fun emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        assertFalse(emailValidator.isValidEmail("@email.com"))
    }

    @Test
    fun emailValidator_InvalidEmailNoDomain_ReturnsFalse() {
        assertFalse(emailValidator.isValidEmail("name@"))
    }

    @Test
    fun emailValidator_InvalidEmailRusChar_ReturnsFalse() {
        assertFalse(emailValidator.isValidEmail("Anтon-Tchaikovsky@yandex.by"))
    }

    @Test
    fun emailValidator_InvalidEmailEqualsChar_ReturnsFalse() {
        assertFalse(emailValidator.isValidEmail("Anton=Tchaikovsky@yandex.by"))
    }

    @Test
    fun emailValidator_InvalidEmailApostropheChar_ReturnsFalse() {
        assertFalse(emailValidator.isValidEmail("D'Anton-Tchaikovsky@yandex.by"))
    }

    @Test
    fun emailValidator_InvalidEmailSpaceChar_ReturnsFalse() {
        assertFalse(emailValidator.isValidEmail("Anton Tchaikovsky@yandex.by"))
    }

    @Test
    fun emailValidator_InvalidEmailDoubleAtChar_ReturnsFalse() {
        assertFalse(emailValidator.isValidEmail("Anton-Tchaikovsky@@yandex.by"))
    }

    @Test
    fun emailValidator_InvalidEmailTooLongDomain_ReturnsFalse() {
        assertFalse(emailValidator.isValidEmail("Anton-Tchaikovsky@yandex.byyyyyyyyyyyyyyyyyyyyyyyyyy"))
    }

    @Test
    fun emailValidator_EmptyString_ReturnsFalse() {
        assertFalse(emailValidator.isValidEmail(""))
    }

    @Test
    fun emailValidator_NullEmail_ReturnsFalse() {
        assertFalse(emailValidator.isValidEmail(null))
    }

    @Test
    fun emailValidator_NullEmail_ReturnsNotNull() {
        assertNotNull(emailValidator.isValidEmail(null))
    }

}