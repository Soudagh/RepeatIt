package com.example.repeatit.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.repeatit.ui.dictionary.ModificationScreen

@Composable
fun ModificationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.MODIFICATION,
        startDestination = ModificationScreen.Addition.route) {
        composable(route = ModificationScreen.Addition.route) {
            ModificationScreen()
        }
        composable(route = ModificationScreen.Update.route) {
            ModificationScreen()
        }
    }

}


sealed class ModificationScreen(val route: String) {
    object Addition : ModificationScreen(route = "ADDITION")
    object Update : ModificationScreen(route = "UPDATE")

}