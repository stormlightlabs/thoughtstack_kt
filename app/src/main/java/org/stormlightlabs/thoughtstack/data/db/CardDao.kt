package org.stormlightlabs.thoughtstack.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CardDao {
    @Query("SELECT * FROM cards WHERE deckOwnerId = :deckId")
    suspend fun getCardsForDeck(deckId: String): List<CardEntity>

    /**
     * Inserts a single [CardEntity] into the database with a REPLACE strategy by calling
     * [insertCards] with a single element variadic argument.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCard(card: CardEntity) {
        insertCards(card)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCards(vararg cards: CardEntity)
}