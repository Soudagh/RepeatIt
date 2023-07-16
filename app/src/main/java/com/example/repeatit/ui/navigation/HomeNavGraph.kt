package com.example.repeatit.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.repeatit.BottomBarScreen
import com.example.repeatit.ui.dictionary.DictScreen
import com.example.repeatit.ui.dictionary.ModificationScreen
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
            DictScreen(navController = navController)
        }
        composable(route = BottomBarScreen.Training.route) {
            TrainScreen()
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen()
        }
        composable(route = Graph.MODIFICATION) {
            ModificationScreen()
        }
        detailsNavGraph()
    }
}



fun NavGraphBuilder.detailsNavGraph() {
    navigation(
        route = Graph.DETAILS,
        startDestination = DetailsScreen.Addition.route
    ) {
        composable(route = DetailsScreen.Addition.route) {
            ModificationScreen()
        }
        composable(route = DetailsScreen.Update.route) {
            ModificationScreen()
        }
    }
}


sealed class DetailsScreen(val route: String) {
    object Addition : DetailsScreen(route = "Addition")
    object Update : DetailsScreen(route = "Update")
}