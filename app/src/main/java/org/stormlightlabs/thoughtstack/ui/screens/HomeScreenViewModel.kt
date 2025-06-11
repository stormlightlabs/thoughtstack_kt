package org.stormlightlabs.thoughtstack.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.stormlightlabs.thoughtstack.data.CardEntity
import org.stormlightlabs.thoughtstack.data.DeckEntity
import org.stormlightlabs.thoughtstack.data.DeckRepository
import org.stormlightlabs.thoughtstack.data.enums.DeckName
import org.stormlightlabs.thoughtstack.data.enums.DifficultyLevel
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repo: DeckRepository
) : ViewModel() {

    val decks: StateFlow<List<DeckEntity>> =
        repo.getDecksFlow().stateIn(viewModelScope, SharingStarted.Companion.Lazily, emptyList())

    // track dialog visibility
    private val _showDialog = MutableStateFlow(false)
    val showDialog = _showDialog.asStateFlow()

    fun onAddCustomClicked() {
        _showDialog.value = true
    }

    fun onDialogDismissed() {
        _showDialog.value = false
    }

    fun addCustomCard(
        title: String, duration: Int, description: String, instructions: String?, photoUri: String?
    ) = viewModelScope.launch {
        val deck = repo.getOrCreateDeck(
            deckId = "custom_deck", name = DeckName.Custom.toString(), description = null,
        )

        val card = CardEntity(
            id = UUID.randomUUID().toString(),
            deckOwnerId = deck.id,
            title = title,
            duration = duration,
            description = description,
            photoUri = photoUri,
            difficulty = DifficultyLevel.Companion.default().toString(),
            instructions = instructions ?: "",
        )

        repo.insertCard(card)

        _showDialog.value = false
    }
}