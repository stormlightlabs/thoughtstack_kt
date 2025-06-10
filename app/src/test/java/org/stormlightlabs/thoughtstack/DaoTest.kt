package org.stormlightlabs.thoughtstack

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.stormlightlabs.thoughtstack.data.AppDatabase
import org.stormlightlabs.thoughtstack.data.CardDao
import org.stormlightlabs.thoughtstack.data.CardEntity
import org.stormlightlabs.thoughtstack.data.DeckDao
import org.stormlightlabs.thoughtstack.data.DeckEntity

/**
 * Unit tests for Room DAOs using an in-memory database.
 */
@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [30])
class DaoTest {
    private lateinit var db: AppDatabase
    private lateinit var deckDao: DeckDao
    private lateinit var cardDao: CardDao

    @Before
    fun setup() {
        val ctx = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(ctx, AppDatabase::class.java).allowMainThreadQueries()
            .build()
        deckDao = db.deckDao()
        cardDao = db.cardDao()
    }

    @After
    fun teardown() {
        db.close()
    }

    @Test
    fun insertAndQueryDecks() = runBlocking {
        val deck = DeckEntity(
            id = "d1",
            name = "ACT",
            description = "A deck for ACT practice",
        )
        deckDao.insertDeck(deck)

        val result = deckDao.getAllDecks()
        Assert.assertEquals(1, result.size)
        Assert.assertEquals("ACT", result[0].name)
    }

    @Test
    fun insertAndQueryCards() = runBlocking {
        val deck = DeckEntity(id = "d2", name = "CBT", description = "A deck for CBT practice")
        deckDao.insertDeck(deck)

        val c1 = CardEntity(
            id = "c1",
            deckOwnerId = "d2",
            duration = 10,
            difficulty = "beginner",
            title = "Identifying Automatic Thoughts",
            description = "Learn to spot thoughts that pop up automatically in response to situations",
            instructions = "Write down a situation and the immediate thoughts that came to mind"
        )
        val c2 = CardEntity(
            id = "c2",
            deckOwnerId = "d2",
            duration = 15,
            difficulty = "intermediate",
            title = "Challenging Negative Thoughts",
            description = "Practice challenging negative thoughts with evidence",
            instructions = "Take a negative thought and find evidence for and against it"
        )
        cardDao.insertCards(c1, c2)

        val cards = cardDao.getCardsForDeck("d2")
        Assert.assertEquals(2, cards.size)
    }
}