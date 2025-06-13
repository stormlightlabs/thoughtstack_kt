package org.stormlightlabs.thoughtstack.data.json

import kotlinx.serialization.Serializable
import org.stormlightlabs.thoughtstack.data.db.CardEntity
import org.stormlightlabs.thoughtstack.data.db.DeckEntity

@Serializable
data class DeckDto(
    val name: String, val description: String, val cards: List<CardDto>
) {
    /**
     *  Map from the JSON shape into a [DeckEntity]
     *  */
    fun toEntity(deckId: String): Pair<DeckEntity, List<CardEntity>> {
        val deckEntity = DeckEntity(
            id = deckId, name = name, description = description
        )
        val cardEntities = cards.map { it.toEntity(deckId) }
        return Pair(deckEntity, cardEntities)
    }
}