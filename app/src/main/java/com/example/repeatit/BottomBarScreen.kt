package com.example.repeatit

import androidx.annotation.StringRes

sealed class BottomBarScreen(val route: String, @StringRes val resourceId: Int, val iconId: Int) {
    object Dictionary : BottomBarScreen("dictionary", R.string.dictionary, R.drawable.baseline_person_24)
    object Training : BottomBarScreen("training", R.string.training, R.drawable.training_24)
    object Profile : BottomBarScreen("profile", R.string.profile, R.drawable.baseline_menu_book_24)
}
