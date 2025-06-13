package org.stormlightlabs.thoughtstack

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.stormlightlabs.thoughtstack.data.db.DeckEntity
import org.stormlightlabs.thoughtstack.data.db.DeckRepository
import javax.inject.Inject

/**
 * ViewModel exposes decks (a [List] of [DeckEntity] instances) as [StateFlow] for Compose.
 */
@HiltViewModel
class ThoughtStackViewModel @Inject constructor(
    repo: DeckRepository
) : ViewModel() {
    val decks: StateFlow<List<DeckEntity>> = repo.getDecksFlow().stateIn(
        viewModelScope, SharingStarted.Lazily, emptyList()
    )
}