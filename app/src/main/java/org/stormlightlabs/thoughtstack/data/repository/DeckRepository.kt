package org.stormlightlabs.thoughtstack.data.repository

import org.stormlightlabs.thoughtstack.data.model.DeckWithCards

/**
 * Defines the operations for fetching and refreshing deck data.
 *
 * Abstracts data access and seeding logic behind a clean interface
 * so upper layers remain decoupled from Room or JSON implementation details.
 */
interface DeckRepository {

    /**
     * Retrieves a deck along with its associated cards by the deck's ID.
     *
     * @param deckId Identifier for the desired deck.
     * @return A [DeckWithCards] instance, or null if no such deck exists.
     */
    suspend fun getDeck(deckId: String): DeckWithCards?

    /**
     * Ensures the database is populated by seeding from provided asset files.
     * Can be used on first launch or to refresh local data.
     *
     * @param assetFiles Filenames under assets/ to load (e.g., listOf("ACT.json", "DBT.json")).
     */
    suspend fun refreshFromAssets(assetFiles: List<String>)
}