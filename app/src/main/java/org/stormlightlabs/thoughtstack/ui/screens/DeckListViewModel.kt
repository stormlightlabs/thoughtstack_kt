package org.stormlightlabs.thoughtstack.ui.screens

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import org.stormlightlabs.thoughtstack.data.CardEntity
import org.stormlightlabs.thoughtstack.data.DeckRepository
import javax.inject.Inject

@HiltViewModel
class DeckListViewModel @Inject constructor(
    private val repo: DeckRepository, savedState: SavedStateHandle
) : ViewModel() {
    private val deckId = savedState.get<String>("deckId")!!

    val cards: StateFlow<List<CardEntity>> =
        repo.getCardsFlow(deckId).stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    private val _currentIndex = MutableStateFlow(0)

    val currentIndex = _currentIndex.asStateFlow()

    fun next() {
        _currentIndex.value = (currentIndex.value + 1).coerceAtMost(cards.value.lastIndex)
    }

    fun back() {
        _currentIndex.value = (currentIndex.value - 1).coerceAtLeast(0)
    }

}