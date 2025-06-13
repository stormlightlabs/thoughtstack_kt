package org.stormlightlabs.thoughtstack.data.constants

enum class DifficultyLevel {
    EASY {
        override fun toString() = "Easy"

        fun toInt() = 0
    },
    MEDIUM {
        override fun toString() = "Medium"

        fun toInt() = 1
    },
    HARD {
        override fun toString() = "Hard"

        fun toInt() = 2
    },
    BEGINNER {
        override fun toString() = "Beginner"

        fun toInt() = 0
    },
    ADVANCED {
        override fun toString() = "Advanced"

        fun toInt() = 1
    },
    INTERMEDIATE {
        override fun toString() = "Intermediate"

        fun toInt() = 2
    },
    EXPERT {
        override fun toString() = "Expert"

        fun toInt() = 3
    };

    companion object {
        fun default() = INTERMEDIATE

        /**
         * Converts an integer value to a pair of synonymous [DifficultyLevel] values.
         */
        fun fromInt(value: Int): Pair<DifficultyLevel, DifficultyLevel> {
            return when (value) {
                1 -> Pair(MEDIUM, INTERMEDIATE)
                2 -> Pair(HARD, ADVANCED)
                3 -> Pair(EXPERT, EXPERT)
                else -> Pair(EASY, BEGINNER)
            }
        }

        /**
         * Converts a string value to a [DifficultyLevel].
         * If the string does not match any known difficulty, it defaults to [INTERMEDIATE].
         */
        fun fromString(value: String): DifficultyLevel {
            return when (value.lowercase()) {
                "easy" -> EASY
                "medium" -> MEDIUM
                "hard" -> HARD
                "beginner" -> BEGINNER
                "advanced" -> ADVANCED
                "expert" -> EXPERT
                else -> INTERMEDIATE
            }
        }

    }
}