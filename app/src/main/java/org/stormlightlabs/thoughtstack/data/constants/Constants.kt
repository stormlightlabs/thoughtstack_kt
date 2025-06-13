package org.stormlightlabs.thoughtstack.data.constants

/**
 * Shared constants across the application.
 */
object Constants {
    const val PREFS_NAME = "thoughtstack_prefs"
    const val PREF_FIRST_RUN = "thoughtstack_first_run"
    const val DECKS_DIR = "decks"

    /**
     * Pair of `id` & `filename`
     */
    val DECK_FILES = DeckName.iterator().map { Pair(it.first, "$DECKS_DIR/${it.second}") }
}