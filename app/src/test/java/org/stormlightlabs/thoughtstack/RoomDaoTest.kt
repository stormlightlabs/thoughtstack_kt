package org.stormlightlabs.thoughtstack

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import org.stormlightlabs.thoughtstack.data.db.AppDatabase
import org.stormlightlabs.thoughtstack.data.model.CardEntity
import org.stormlightlabs.thoughtstack.data.model.DeckEntity
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class RoomDaoTest {
    private lateinit var db: AppDatabase

    @Before
    fun setup() {
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(), AppDatabase::class.java
        ).allowMainThreadQueries().build()
    }

    @After
    fun tearDown() {
        db.close()
    }

    @Test
    fun insertAndQueryDecks() = runBlocking {
        val deck = DeckEntity("testDeck", "Test Deck")
        db.deckDao().insertDeck(deck)

        val decks = db.deckDao().getAllDecks()

        assertEquals(1, decks.size)
        assertEquals("Test Deck", decks.first().name)
    }

    @Test
    fun insertAndQueryCards() = runBlocking {
        val deckId = "testDeck"
        db.deckDao().insertDeck(DeckEntity(deckId, "Test"))

        val card = CardEntity("c1", deckId, "Front", "Back", null)
        db.cardDao().insertCard(card)

        val cards = db.cardDao().getCardsForDeck(deckId)

        assertEquals(1, cards.size)
        assertEquals("Front", cards.first().frontText)
    }
}
