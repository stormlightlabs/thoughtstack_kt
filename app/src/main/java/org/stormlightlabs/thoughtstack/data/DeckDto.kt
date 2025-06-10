package org.stormlightlabs.thoughtstack.data

import kotlinx.serialization.Serializable

@Serializable
data class DeckDto(
    val deckId: String, val name: String, val description: String, val cards: List<CardDto>
) {
    /**
     *  Map from the JSON shape into a [DeckEntity]
     *  */
    fun toEntity(): Pair<DeckEntity, List<CardEntity>> {
        val deckEntity = DeckEntity(
            id = deckId, name = name, description = description
        )
        val cardEntities = cards.map { it.toEntity(deckId) }
        return Pair(deckEntity, cardEntities)
    }
}