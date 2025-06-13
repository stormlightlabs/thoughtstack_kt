package org.stormlightlabs.thoughtstack

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.testing.CustomTestApplication
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.stormlightlabs.thoughtstack.data.enums.DeckName
import kotlin.random.Random

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class NavigationTest {
    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    private val rand = Random(12345L)

    private fun deckLabel() = DeckName.allDeckNames().random(rand)

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test fun pressingDeckNavigatesToDeckScreen() {
        val label = deckLabel()
        composeRule.onNodeWithText(label.toString())
    }
}