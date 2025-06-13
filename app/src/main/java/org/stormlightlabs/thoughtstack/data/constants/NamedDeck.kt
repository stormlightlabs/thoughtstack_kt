package org.stormlightlabs.thoughtstack.data.constants

interface NamedDeck {
    val id : String
    /**
     * Returns the name of the deck.
     */
    override fun toString(): String

    /**
     * Returns the filename of the deck.
     */
    fun filename(): String

}
