package org.stormlightlabs.thoughtstack.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Provides data to ViewModels by abstracting DAO usage.
 */
@Singleton
class DeckRepository @Inject constructor(
    private val deckDao: DeckDao, private val cardDao: CardDao
) {
    /**
     * Returns all [DeckEntity] objects as a [Flow] for Compose consumption.
     * */
    fun getDecksFlow(): Flow<List<DeckEntity>> = flow {
        emit(deckDao.getAllDecks())
    }

    /**
     * Return all [CardEntity] objects for a specific deck as a [Flow].
     */
    fun getCardsFlow(deckId: String): Flow<List<CardEntity>> = flow {
        emit(cardDao.getCardsForDeck(deckId))
    }

    /**
     * Returns a list of [CardEntity] for a specific deck.
     * */
    suspend fun getCards(deckId: String) = cardDao.getCardsForDeck(deckId)

    /**
     * Inserts a new [DeckEntity] into the database.
     * */
    suspend fun insertDeck(deck: DeckEntity) {
        deckDao.insertDeck(deck)
    }

    /**
     * Inserts a new [CardEntity] into the database.
     */
    suspend fun insertCard(card: CardEntity) {
        cardDao.insertCard(card)
    }

    suspend fun getOrCreateDeck(deckId: String, name: String, description: String?): DeckEntity {
        var deck = deckDao.getDeckById(deckId) ?: deckDao.getDeckByName(name)

        return if (deck == null) {
            deck = DeckEntity(id = deckId, name = name, description = description ?: "")

            insertDeck(deck)

            deck
        } else {
            deck
        }
    }
}