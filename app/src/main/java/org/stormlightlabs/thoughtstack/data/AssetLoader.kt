package org.stormlightlabs.thoughtstack.data

import android.content.Context
import kotlinx.serialization.json.Json
import org.stormlightlabs.thoughtstack.data.json.DeckDto

/**
 * Loads decks.json from assets and populates the Room database.
 */
object AssetLoader {
    private val json = Json { ignoreUnknownKeys = true }

    suspend fun loadFromAssets(context: Context, db: AppDatabase) {
        for (deckFilePath in Constants.DECK_FILES) {
            val contents = context.assets.open(deckFilePath).bufferedReader().use { it.readText() }

            val deck: DeckDto = json.decodeFromString(contents)
            val (deckEntity, cardEntities) = deck.toEntity()
            db.deckDao().insertDeck(deckEntity)
            db.cardDao().insertCards(*cardEntities.toTypedArray())
        }
    }
}