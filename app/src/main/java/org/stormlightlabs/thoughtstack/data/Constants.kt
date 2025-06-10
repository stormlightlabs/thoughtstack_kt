package org.stormlightlabs.thoughtstack.data

/**
 * Shared constants across the application.
 */
object Constants {
    const val PREFS_NAME = "thoughtstack_prefs"
    const val PREF_FIRST_RUN = "thoughtstack_first_run"
    const val DECKS_DIR = "decks"

    val DECK_FILES = allFilenames().map { "$DECKS_DIR/$it" }
}