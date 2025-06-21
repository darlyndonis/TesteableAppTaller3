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


    // Test 2: verifica que cuando el monto de la cuenta (billAmount) es inválido, como un string vacío ("")
    // la función calculateTip devuelve 0.0 como resultado de la propina.
    @Test
    fun calculateTip_returnsZero_whenAmountIsInvalid() {
        // Simula que el usuario escribió un monto vacío en el campo de texto
        val billAmount = ""

        // Intenta convertir el monto a Double. Si falla (por ser vacío o no numérico), retorna 0.0
        // esto simula el comportamiento real del código en la UI con: `val bill = billAmount.toDoubleOrNull() ?: 0.0`
        val bill = billAmount.toDoubleOrNull() ?: 0.0

        // Llama a la función que calcula la propina con: monto = 0.0 (porque el string era inválido)
        // porcentaje de propina = 20% sin redondeo
        val tip = calculateTip(bill, 20, false)

        // Verifica que la propina calculada sea 0.0 ya que el monto no era válido, no debería haber propina alguna
        assertEquals(0.0, tip, 0.0)
    }




}


