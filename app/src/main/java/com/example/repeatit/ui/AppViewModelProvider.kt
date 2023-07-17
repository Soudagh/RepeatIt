package com.example.repeatit.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.repeatit.RepeatItApplication
import com.example.repeatit.ui.dictionary.ThemeEntryScreen
import com.example.repeatit.ui.dictionary.ThemeEntryViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
//        initializer {
//            ThemeEditViewModel(
//                this.createSavedStateHandle()
//            )
//        }

        initializer {
            ThemeEntryViewModel()
        }
    }
}


fun CreationExtras.repeatItApp(): RepeatItApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as RepeatItApplication)