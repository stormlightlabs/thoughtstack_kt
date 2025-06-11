package org.stormlightlabs.thoughtstack.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import org.stormlightlabs.thoughtstack.ui.components.CustomCardDialog
import org.stormlightlabs.thoughtstack.ui.components.DeckCardItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel(), onDeckClick: (String) -> Unit
) {
    val decks by viewModel.decks.collectAsState()
    val showDialog by viewModel.showDialog.collectAsState()

    Scaffold(topBar = { TopAppBar(title = { Text("All Decks") }) }, floatingActionButton = {
        FloatingActionButton(onClick = viewModel::onAddCustomClicked) {
            Icon(Icons.Default.Add, contentDescription = "Add Custom Card")
        }
    }) { padding ->
        LazyColumn(Modifier.padding(padding)) {
            items(count = decks.size, itemContent = { index ->
                val deck = decks[index]
                DeckCardItem(
                    deck = deck,
                    onClick = { onDeckClick(deck.id) },
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            })
        }

        if (showDialog) {
            CustomCardDialog(
                onDismiss = viewModel::onDialogDismissed,
                onSave = { title, duration, desc, photoUri ->
                    viewModel.addCustomCard(
                        title = title,
                        duration = duration,
                        description = desc,
                        instructions = null,
                        photoUri = photoUri
                    )
                })
        }
    }
}
