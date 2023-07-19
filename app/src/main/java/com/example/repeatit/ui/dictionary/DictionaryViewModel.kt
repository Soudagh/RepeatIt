package com.example.repeatit.ui.dictionary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.repeatit.data.Theme
import com.example.repeatit.data.ThemesRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class DictViewModel(themesRepository: ThemesRepository) : ViewModel() {
    val dictUiState: StateFlow<DictUiState> =
        themesRepository.getAllThemesStream().map { DictUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = DictUiState()
            )

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}


data class DictUiState(val themeList: List<Theme> = listOf())