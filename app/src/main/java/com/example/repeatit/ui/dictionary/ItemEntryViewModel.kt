//package com.example.repeatit.ui.dictionary
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.repeatit.data.entities.Item
//import com.example.repeatit.data.repositories.ItemsRepository
//import kotlinx.coroutines.flow.SharingStarted
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.flow.map
//import kotlinx.coroutines.flow.stateIn
//
//class ItemEntryViewModel(private val itemsRepository: ItemsRepository) : ViewModel() {
//    val itemsUiState: StateFlow<ItemUiState> =
//        itemsRepository.getAllItemsStream().map { ItemUiState(it) }
//            .stateIn(
//                scope = viewModelScope,
//                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
//                initialValue = ItemUiState()
//            )
//
//    companion object {
//        private const val TIMEOUT_MILLIS = 5000L
//    }
//
//}
//
//
//data class ItemUiState(val itemList: List<Item> = listOf())