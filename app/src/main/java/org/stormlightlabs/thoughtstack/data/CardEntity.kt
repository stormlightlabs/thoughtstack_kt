package org.stormlightlabs.thoughtstack.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey
import androidx.room.Index

/**
 * Represents a card in a [DeckEntity], with its associated metadata.
 */
@Entity(
    tableName = "cards",
    foreignKeys = [
        ForeignKey(
            entity = DeckEntity::class,
            parentColumns = ["id"],
            childColumns = ["deckOwnerId"],
            onDelete = ForeignKey.CASCADE
        ),
    ],
    indices = [Index("deckOwnerId")]
)
data class CardEntity(
    @PrimaryKey val id: String,
    val deckOwnerId: String,
    val title: String,
    val duration: Int,
    val difficulty: String,
    val description: String,
    val instructions: String,
    val photoUri: String? = null
)