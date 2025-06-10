package org.stormlightlabs.thoughtstack.ui


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import org.stormlightlabs.thoughtstack.DeckViewModel

/**
 * Displays a list of decks in a Compose Scaffold.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeckListScreen(viewModel: DeckViewModel = hiltViewModel()) {
    val decks = viewModel.decks.collectAsState().value

    Scaffold(topBar = {
        TopAppBar(title = { Text("Decks") })
    }) { padding ->
        LazyColumn(contentPadding = padding) {
            items(decks) { deck ->
                DeckCardItem(deck = deck, modifier = Modifier.padding(8.dp))
            }
        }
    }
}