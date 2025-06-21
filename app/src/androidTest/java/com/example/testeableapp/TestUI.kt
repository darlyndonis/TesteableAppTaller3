package com.example.testeableapp

import androidx.compose.ui.semantics.SemanticsActions
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performSemanticsAction
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@OptIn(ExperimentalTestApi::class)
@RunWith(AndroidJUnit4::class)
class TestUI {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()


    // 1. Validar presencia de elementos UI: monto, porcentaje, número de personas
    @Test
    fun testElementsAreVisible() {
        composeTestRule.onNodeWithTag("BillInput").assertIsDisplayed()
        composeTestRule.onNodeWithTag("TipSlider").assertIsDisplayed()
        composeTestRule.onNodeWithTag("DecreasePeople").assertIsDisplayed()
        composeTestRule.onNodeWithTag("IncreasePeople").assertIsDisplayed()
        composeTestRule.onNodeWithTag("RoundUpCheckbox").assertIsDisplayed()
        composeTestRule.onNodeWithTag("TipAmount").assertIsDisplayed()
        composeTestRule.onNodeWithTag("TotalPerPerson").assertIsDisplayed()
    }


    // 2. Cambiar slider del porcentaje de propina y verificar cálculo
    @Test
    fun testChangeTipSliderUpdatesTip() {

        // Ingresamos monto base
        composeTestRule.onNodeWithTag("BillInput").performTextInput("100.00")

        // Cambiar slider a 25% (SetProgress usa valor entre 0f y 1f, este slider va de 0f a 50f)
        composeTestRule.onNodeWithTag("TipSlider").performSemanticsAction(SemanticsActions.SetProgress) { it(25f) }

        // Validar propina: 25% de 100.00 = 25.00
        composeTestRule.onNodeWithTag("TipAmount").assertTextContains("Propina: $25.00")

    }


    // 3. Redondear propina y validar cambio de cálculo
    @Test
    fun testRoundUpChangesTip() {
        // Ingresar monto
        composeTestRule.onNodeWithTag("BillInput").performTextInput("100.75")

        // Aseguramos que nuestro RoundedCheckBox de "Redondear propina" esté desactivado inicialmente
        composeTestRule.onNodeWithTag("RoundUpCheckbox").assertIsOff()

        // Validar propina sin redondeo
        composeTestRule.onNodeWithTag("TipAmount").assertTextContains("Propina: $15.11")

        // Activar redondeo
        composeTestRule.onNodeWithTag("RoundUpCheckbox").performClick()

        // Validamos cambio en propina (ceil(15.8625) = 16.0)
        composeTestRule.onNodeWithTag("TipAmount").assertTextContains("Propina: $16.00")
    }
}