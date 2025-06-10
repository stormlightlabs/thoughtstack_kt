package org.stormlightlabs.thoughtstack.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "decks")
data class DeckEntity(
    @PrimaryKey val deckId: String,
    val name: String
)