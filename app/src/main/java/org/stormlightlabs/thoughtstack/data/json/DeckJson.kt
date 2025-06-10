package org.stormlightlabs.thoughtstack.data.json

/**
 * Represents the JSON structure for a deck in assets.
 *
 * Mirrors the schema defined in "decks.schema.json".
 *
 * @param id Unique identifier used as primary key.
 * @param name Display name shown to users.
 * @param cards List of cards belonging to this deck.
 */
data class DeckJson(
    val id: String, val name: String, val cards: List<CardJson>
)