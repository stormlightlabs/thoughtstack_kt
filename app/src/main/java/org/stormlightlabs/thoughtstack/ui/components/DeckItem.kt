package org.stormlightlabs.thoughtstack.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.stormlightlabs.thoughtstack.data.DeckEntity

/**
 * A reusable card widget for displaying deck name.
 */
@Composable
fun DeckItem(
    deck: DeckEntity, modifier: Modifier = Modifier, onClick: (() -> Unit)? = null
) {
    val mod = modifier.clickable(enabled = onClick != null) { onClick?.invoke() }

    Card(mod) {
        Text(
            text = deck.name,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(16.dp)
        )
    }
}