package org.stormlightlabs.thoughtstack.data.enums

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
