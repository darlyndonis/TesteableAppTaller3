package com.example.testeableapp

import org.junit.Test
import org.junit.Assert.*
import com.example.testeableapp.ui.Screens.calculateTip

class TestAditionalUnitarias {

    // Test 1: Verifica que el monto de 0 da propina de 0
    @Test
    fun calculateTip_zeroAmount_returnsZeroTip() {
        // Monto de la cuenta es cero
        val amount = 0.0
        val tipPercent = 20
        val roundUp = false

        // Llamamos a la función de cálculo
        val result = calculateTip(amount, tipPercent, roundUp)

        // Esperamos que la propina sea 0.0
        val expected = 0.0
        assertEquals("Con cuenta de 0, la propina debe ser 0", expected, result, 0.01)
    }


    // Test 2: Verifica cuando el porcentaje de propina es negativo.
    @Test
    fun calculateTip_withNegativeTipPercent_returnsZero() {
        val amount = 100.0
        val negativeTipPercent = -10
        val roundUp = false

        val result = calculateTip(amount, negativeTipPercent, roundUp)

        assertEquals(
            "Cuando el porcentaje de propina es negativo, la función debe retornar 0.0",
            0.0,
            result,
            0.001
        )
    }
}


