package org.stormlightlabs.thoughtstack.data.json

import kotlinx.serialization.Serializable
import org.stormlightlabs.thoughtstack.data.CardEntity
import org.stormlightlabs.thoughtstack.data.DeckEntity

@Serializable
data class DeckDto(
    val deckId: String, val name: String, val description: String, val cards: List<CardDto>
) {
    /**
     *  Map from the JSON shape into a [org.stormlightlabs.thoughtstack.data.DeckEntity]
     *  */
    fun toEntity(): Pair<DeckEntity, List<CardEntity>> {
        val deckEntity = DeckEntity(
            id = deckId, name = name, description = description
        )
        val cardEntities = cards.map { it.toEntity(deckId) }
        return Pair(deckEntity, cardEntities)
    }
}