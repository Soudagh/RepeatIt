package com.example.repeatit.ui.dictionary

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.repeatit.data.Theme
import com.example.repeatit.data.ThemesRepository

class ThemeEntryViewModel(private val themesRepository: ThemesRepository) : ViewModel() {

    var themeUiState by mutableStateOf(ThemeUiState())
        private set


    fun updateUiState(themeDetails: ThemeDetails) {
        themeUiState = ThemeUiState(themeDetails = themeDetails, isEntryValid = validateInput(themeDetails))
    }

    private fun validateInput(uiState: ThemeDetails = themeUiState.themeDetails): Boolean {
        return with(uiState) {
            name.isNotBlank() && description.isNotBlank()
        }
    }

    suspend fun saveTheme() {
        if (validateInput()) {
            themesRepository.insertTheme(themeUiState.themeDetails.toTheme())
        }
    }


}

data class ThemeUiState(
    val themeDetails: ThemeDetails = ThemeDetails(),
    val isEntryValid: Boolean = false
)

data class ThemeDetails(
    val id: Int = 0,
    val name: String = "",
    val description: String = "",
)


fun ThemeDetails.toTheme(): Theme = Theme(
    id = id,
    name = name,
    description = description
)

fun Theme.toThemeUiState(isEntryValid: Boolean = false): ThemeUiState = ThemeUiState(
    themeDetails = this.toThemeDetails(),
    isEntryValid = isEntryValid
)


fun Theme.toThemeDetails(): ThemeDetails = ThemeDetails(
    id = id,
    name = name,
    description = description
)


