package com.example.repeatit.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.repeatit.R
import com.example.repeatit.ui.dictionary.ThemeEntryScreen

@Composable
fun ThemeGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.MODIFICATION,
        startDestination = ModificationScreen.Addition.route) {
        composable(route = ModificationScreen.Addition.route) {
            ThemeEntryScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
        composable(route = ModificationScreen.Update.route) {
            ThemeEntryScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }

}


sealed class ModificationScreen(val route: String, val titleRes: Int) {
    object Addition : ModificationScreen(route = "ADDITION", titleRes = R.string.theme_entry_title)
    object Update : ModificationScreen(route = "UPDATE", titleRes = R.string.theme_update_title)

}