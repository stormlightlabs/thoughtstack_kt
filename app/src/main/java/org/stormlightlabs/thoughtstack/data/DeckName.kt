package org.stormlightlabs.thoughtstack.data

interface NamedDeck {
    /**
     * Returns the name of the deck.
     */
    override fun toString(): String

    /**
     * Returns the filename of the deck.
     */
    fun filename(): String
}

enum class DeckName : NamedDeck {
    CBT {
        override fun toString(): String = "Cognitive Behavioral Therapy"

        override fun filename(): String = "cbt.json"
    },
    DBT {
        override fun toString(): String = "Dialectical Behavior Therapy"

        override fun filename(): String = "dbt.json"
    },
    ACT {
        override fun toString(): String = "Acceptance and Commitment Therapy"

        override fun filename(): String = "act.json"
    },
    Creativity {
        override fun toString(): String = "Creativity"

        override fun filename(): String = "creativity.json"
    },
    Exercise {
        override fun toString(): String = "Movement and Exercise"

        override fun filename(): String = "movement.json"
    },
    Rest {
        override fun toString(): String = "Rest & Recharge"

        override fun filename(): String = "recharge.json"
    },
    Custom {
        override fun toString(): String = "Custom Deck"

        override fun filename(): String =
            throw UnsupportedOperationException("Custom decks do not have a filename")
    }
}

/**
 * Return all [DeckName] values as a list.
 */
fun allDeckNames(): List<DeckName> = listOf(
    DeckName.CBT,
    DeckName.DBT,
    DeckName.ACT,
    DeckName.Exercise,
    DeckName.Creativity,
    DeckName.Rest,
    DeckName.Custom
)

/**
 * Returns a list of all deck filenames.
 */
fun allFilenames(): List<String> = listOf(
    DeckName.CBT,
    DeckName.DBT,
    DeckName.ACT,
    DeckName.Exercise,
    DeckName.Rest,
    DeckName.Creativity
).map { it.filename() }