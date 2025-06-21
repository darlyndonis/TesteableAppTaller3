package com.example.testeableapp

import com.example.testeableapp.ui.Screens.calculateTip
import org.junit.Test
import kotlin.test.assertEquals

class TipCalculatorUnitTest {

    @Test
    fun calculateTip_with37PercentAndRounding() {
        val result = calculateTip(100.0, 37, true)
        assertEquals(37.0, result, 0.01)
    }

    @Test
    fun calculateTip_withNegativeAmount_returnsZero() {
        val result = calculateTip(-50.0, 20, false)
        assertEquals(0.0, result, 0.01)
    }

    @Test
    fun calculateTotalPerPerson() {
        val amount = 120.0
        val tip = calculateTip(amount, 20, false)
        val total = amount + tip
        val people = 3
        assertEquals(48.0, total / people, 0.01)
    }
}