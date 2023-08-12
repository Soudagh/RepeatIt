package com.example.repeatit.ui.dictionary

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.repeatit.data.entities.Item
import com.example.repeatit.data.repositories.ItemsRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class ItemsViewModel(
    itemsRepository: ItemsRepository,
    savedStateHandle: SavedStateHandle
    ) : ViewModel() {

    private val itemId: Int? = savedStateHandle.get("id")

    val itemsUiState: StateFlow<ItemUiState> =

        itemsRepository.getItemsById(itemId).map { ItemUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = ItemUiState()
            )
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}


data class ItemUiState(val itemsList: List<Item> = listOf())