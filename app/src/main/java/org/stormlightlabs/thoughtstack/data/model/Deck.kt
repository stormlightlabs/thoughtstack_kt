package org.stormlightlabs.thoughtstack.data.model

/**
 * Enum representing the different decks available in the application.
 *
 * Each deck corresponds to a specific type of mental health practice or exercise.
 * Used to categorize and manage decks within the app.
 */
enum class Deck {
    ACT {
        override fun toString(): String {
            return "Acceptance and Commitment Therapy (ACT)"
        }
    },
    DBT {
        override fun toString(): String {
            return "Dialectical Behavior Therapy (DBT)"
        }
    },
    CBT {
        override fun toString(): String {
            return "Cognitive Behavioral Therapy (CBT)"
        }
    },
    Exercise {
        override fun toString(): String {
            return "Exercise Deck"
        }
    },
    Meditation {
        override fun toString(): String {
            return "Meditation Deck"
        }
    },
    Custom {
        override fun toString(): String {
            return "Custom Deck"
        }
    }
}