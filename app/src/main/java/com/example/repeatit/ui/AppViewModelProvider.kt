package com.example.repeatit.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.repeatit.RepeatItApplication
import com.example.repeatit.ui.dictionary.DictViewModel
import com.example.repeatit.ui.dictionary.ItemsViewModel
import com.example.repeatit.ui.dictionary.ThemeEntryScreen
import com.example.repeatit.ui.dictionary.ThemeEntryViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            ThemeEntryViewModel(repeatItApp().container.themesRepository)
        }

        initializer {
            DictViewModel(repeatItApp().container.themesRepository)
        }

        initializer {
            ItemsViewModel(
                repeatItApp().container.itemsRepository,
                this.createSavedStateHandle()
            )
        }
    }
}


fun CreationExtras.repeatItApp(): RepeatItApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as RepeatItApplication)