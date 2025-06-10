package org.stormlightlabs.thoughtstack.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CardDao {
    @Query("SELECT * FROM cards WHERE deckOwnerId = :deckId")
    suspend fun getCardsForDeck(deckId: String): List<CardEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCards(vararg cards: CardEntity)
}