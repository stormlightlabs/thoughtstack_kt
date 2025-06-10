package org.stormlightlabs.thoughtstack.data

import kotlinx.serialization.Serializable

@Serializable
data class CardDto(
    val cardId: String,
    val title: String,
    val duration: Int,
    val difficulty: String,
    val description: String,
    val instructions: String
) {
    /**
     * Map from the JSON shape of a card into a [CardEntity].
     */
    fun toEntity(deckId: String): CardEntity = CardEntity(
        id = cardId,
        deckOwnerId = deckId,
        title = title,
        duration = duration,
        difficulty = difficulty,
        description = description,
        instructions = instructions
    )
}