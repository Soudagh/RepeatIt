package com.example.repeatit.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.repeatit.BottomBarScreen
import com.example.repeatit.ui.dictionary.ItemsScreen
import com.example.repeatit.ui.dictionary.ThemeEntryScreen
import com.example.repeatit.ui.dictionary.ThemesScreen
import com.example.repeatit.ui.profile.ProfileScreen
import com.example.repeatit.ui.trainings.TrainScreen


@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomBarScreen.Dictionary.route
    ) {
        composable(route = BottomBarScreen.Dictionary.route) {
            ThemesScreen(navController = navController)
        }
        composable(route = BottomBarScreen.Training.route) {
            TrainScreen()
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen()
        }
        composable(route = Graph.MODIFICATION) {
            ThemeEntryScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
        composable(route = Graph.ITEMS) {
            ItemsScreen()
        }
    }
}
