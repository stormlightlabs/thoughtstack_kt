package org.stormlightlabs.thoughtstack.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

/**
 * Displays a list of decks in a Compose Scaffold.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeckListScreen(
    deckId: String, viewModel: DeckListViewModel = hiltViewModel(), onBack: () -> Unit
) {
    val cards by viewModel.cards.collectAsState()
    val index by viewModel.currentIndex.collectAsState()

    Scaffold(topBar = {
        TopAppBar(title = { Text(cards.getOrNull(index)?.title ?: "") }, navigationIcon = {
            IconButton(onClick = onBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, null) }
        })
    }) { padding ->
        if (cards.isEmpty()) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("No cards in this deck.")
            }
        } else {
            val card = cards[index]

            Column(
                Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(card.description, style = MaterialTheme.typography.headlineSmall)
                Spacer(Modifier.height(24.dp))
                Row {
                    Button(onClick = viewModel::back, enabled = index > 0) {
                        Text("Back")
                    }
                    Spacer(Modifier.width(16.dp))
                    Button(onClick = viewModel::next, enabled = index < cards.lastIndex) {
                        Text("Next")
                    }
                }
            }
        }
    }
}
