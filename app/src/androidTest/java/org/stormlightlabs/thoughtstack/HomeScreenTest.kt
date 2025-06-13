package org.stormlightlabs.thoughtstack

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

/**
 * FIXME: [EmulatorConsole]: Failed to start Emulator console for 555
 */
class HomeScreenTest {
    @get:Rule
    val rule = createAndroidComposeRule<MainActivity>()

    private fun openDialog() {
        rule.onNode(hasContentDescription("Add Custom Card")).performClick()
    }

    @Test
    fun homeShowsList() {
        val interaction = rule.onNodeWithText(text = "All Decks")
        interaction.assertIsDisplayed()
    }

    @Test
    fun openDialogFAB() {
        openDialog()
        for (interaction in listOf(
            rule.onNodeWithText(text = "Add Custom Card"),
            rule.onNodeWithText(text = "Title"),
            rule.onNodeWithText(text = "Description")
        )) {
            interaction.assertIsDisplayed()
        }
    }

    @Test
    fun cancelHidesDialog() {
        openDialog()
        rule.onNodeWithText("Cancel").performClick()
        rule.onNodeWithText("Add Custom Card").assertDoesNotExist()
    }
}