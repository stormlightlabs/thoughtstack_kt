package org.stormlightlabs.thoughtstack.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DeckDao {
    @Query("SELECT * FROM decks")
    suspend fun getAllDecks(): List<DeckEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDeck(deck: DeckEntity)

    @Query("SELECT * FROM decks WHERE id = :id AND name = :name")
    suspend fun findDeck(id: String, name: String): DeckEntity?

    @Query("SELECT * FROM decks WHERE id = :id")
    suspend fun getDeckById(id: String): DeckEntity?

    @Query("SELECT * FROM decks WHERE name = :name")
    suspend fun getDeckByName(name: String): DeckEntity?
}