package org.stormlightlabs.thoughtstack.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.stormlightlabs.thoughtstack.data.model.DeckEntity

@Dao
interface DeckDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDeck(deck: DeckEntity)

    @Query("SELECT * FROM decks")
    suspend fun getAllDecks(): List<DeckEntity>
}