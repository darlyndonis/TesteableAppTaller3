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


    // Test 2: verifica que cuando el porcentaje de propina es 0%,
    // la función calculateTip devuelva 0.0, incluso si el redondeo está activado.
    @Test
    fun calculateTip_returnsZero_whenTipPercentageIsZero() {
        // Ejecutamos la funcion calculateTip con un monto de 100
        // con porcentaje de propina de 0%
        // El redondeo esta activado (aunque no influye en nada ya que la propina es 0)
        val tip = calculateTip(100.0, 0, true)
        // Verifica que el resultado de la propina sea exactamente 0.0
        // Esto asegura que incluso con roundUp = true, no se altere el valor 0.0
        assertEquals(0.0, tip, 0.0)
    }


}


