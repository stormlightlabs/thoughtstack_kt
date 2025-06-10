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
     * Returns a list of [CardEntity] for a specific deck.
     * */
    suspend fun getCards(deckId: String) = cardDao.getCardsForDeck(deckId)
}