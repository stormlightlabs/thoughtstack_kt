package org.stormlightlabs.thoughtstack.data.json

/**
 * Represents the JSON structure for a single card.
 *
 * @param id Unique identifier for the card.
 * @param prompt The prompt or question text.
 * @param details The corresponding details or description for the prompt.
 */
data class CardJson(
    val id: String, val prompt: String, val details: String
)