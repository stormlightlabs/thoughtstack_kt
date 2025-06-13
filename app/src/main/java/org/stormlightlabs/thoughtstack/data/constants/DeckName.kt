package org.stormlightlabs.thoughtstack.data.constants

import kotlin.enums.enumEntries

enum class DeckName : NamedDeck {
    CBT {
        override val id = "cbt"

        override fun toString(): String = "Cognitive Behavioral Therapy"

        override fun filename(): String = "cbt.json"
    },
    DBT {
        override val id = "dbt"

        override fun toString(): String = "Dialectical Behavior Therapy"

        override fun filename(): String = "dbt.json"
    },
    ACT {
        override val id = "act"

        override fun toString(): String = "Acceptance and Commitment Therapy"

        override fun filename(): String = "act.json"
    },
    Creativity {
        override val id = "creativity"

        override fun toString(): String = "Creativity"

        override fun filename(): String = "creativity.json"
    },
    Exercise {
        override val id = "exercise"

        override fun toString(): String = "Movement and Exercise"

        override fun filename(): String = "movement.json"
    },
    Rest {
        override val id = "rest"

        override fun toString(): String = "Rest & Recharge"

        override fun filename(): String = "recharge.json"
    },
    Custom {
        override val id = "custom"

        override fun toString(): String = "Custom Deck"

        override fun filename(): String =
            throw UnsupportedOperationException("Custom decks do not have a filename")
    };

    companion object {
        /**
         * Return all [DeckName] values as a list.
         */
        fun allDeckNames(): List<DeckName> = listOf(
            CBT, DBT, ACT, Exercise, Creativity, Rest, Custom
        )

        /**
         * Return a list of all ids
         */
        fun allDeckIds(): List<String> = allDeckNames().map { it.id }

        /**
         * Returns a list of all deck filenames.
         */
        fun allFilenames(): List<String> = listOf(
            CBT, DBT, ACT, Exercise, Rest, Creativity
        ).map { it.filename() }

        fun iterator(): List<Pair<String, String>> =
            listOf(CBT, DBT, ACT, Exercise, Rest, Creativity).map { Pair(it.id, it.filename()) }

        /**
         * Returns a [DeckName] wrapped in a [Result] from a string name.
         */
        fun fromString(name: String): Result<DeckName> {
            val deckName =
                enumEntries<DeckName>().find { it.toString().equals(name, ignoreCase = true) }

            if (deckName != null) {
                return Result.success(deckName)
            }

            return Result.failure(IllegalArgumentException("Unknown deck name: $name"))
        }
    }
}

