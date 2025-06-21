package com.example.testeableapp

import org.junit.Test
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.*
import com.example.testeableapp.ui.Screens.TipCalculatorScreen
import org.junit.Rule

class TipCalculatorUITest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun increaseNumberOfPeople_updatesDisplayedValue() {
        composeTestRule.onNodeWithText("1").assertExists()

        // Cuando se presiona el botón "+"
        composeTestRule.onNodeWithText("+").performClick()

        // Verifica que ahora el número es 2
        composeTestRule.onNodeWithText("2").assertExists()
    }

    @Test
    fun totalPerPerson_changesWhenPeopleChange() {
        composeTestRule.onNodeWithText("Monto de la cuenta").performTextInput("120")
        composeTestRule.onNodeWithText("Total por persona: $138.00").assertExists()
        composeTestRule.onNodeWithText("+").performClick()
        composeTestRule.onNodeWithText("Total por persona: $69.00").assertExists()
    }
}