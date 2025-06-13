package org.stormlightlabs.thoughtstack.data.json

import kotlinx.serialization.Serializable
import org.stormlightlabs.thoughtstack.data.CardEntity

@Serializable
data class CardDto(
    val id: String,
    val title: String,
    val duration: Int,
    val difficulty: String,
    val description: String,
    val instructions: String
) {
    /**
     * Map from the JSON shape of a card into a [org.stormlightlabs.thoughtstack.data.CardEntity].
     */
    fun toEntity(deckId: String): CardEntity = CardEntity(
        id = id,
        deckOwnerId = deckId,
        title = title,
        duration = duration,
        difficulty = difficulty,
        description = description,
        instructions = instructions
    )
}