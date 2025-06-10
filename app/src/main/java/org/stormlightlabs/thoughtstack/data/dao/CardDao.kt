package org.stormlightlabs.thoughtstack.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.stormlightlabs.thoughtstack.data.model.CardEntity

@Dao
interface CardDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCard(card: CardEntity)

    @Query("SELECT * FROM cards WHERE deckOwnerId = :deckId")
    suspend fun getCardsForDeck(deckId: String): List<CardEntity>
}