package org.stormlightlabs.thoughtstack.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "cards", foreignKeys = [ForeignKey(
        entity = DeckEntity::class,
        parentColumns = ["deckId"],
        childColumns = ["deckOwnerId"],
        onDelete = ForeignKey.CASCADE
    )], indices = [Index("deckOwnerId")]
)
data class CardEntity(
    @PrimaryKey val cardId: String,
    val deckOwnerId: String,
    val frontText: String,
    val backText: String? = null,
    val imageUri: String? = null
)
