package org.stormlightlabs.thoughtstack.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.stormlightlabs.thoughtstack.data.DeckEntity

/**
 * A reusable card widget for displaying deck name.
 */
@Composable
fun DeckCardItem(
    deck: DeckEntity, modifier: Modifier = Modifier, onClick: (() -> Unit)? = null
) {
    Card(
        modifier = modifier.clickable(enabled = onClick != null) { onClick?.invoke() }) {
        Text(
            text = deck.name,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(16.dp)
        )
    }
}