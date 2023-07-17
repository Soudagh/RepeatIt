package com.example.repeatit.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.repeatit.BottomBarScreen
import com.example.repeatit.ui.dictionary.DictScreen
import com.example.repeatit.ui.dictionary.ThemeEntryScreen
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
            DictScreen()
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
//        detailsNavGraph()
    }
}



//fun NavGraphBuilder.detailsNavGraph() {
//    navigation(
//        route = Graph.DETAILS,
//        startDestination = DetailsScreen.Addition.route
//    ) {
//        composable(route = DetailsScreen.Addition.route) {
//            ThemeEntryScreen(
//                navigateBack = { navController.popBackStack() },
//                onNavigateUp = { navController.navigateUp() }
//            )
//        }
//        composable(route = DetailsScreen.Update.route) {
//            ThemeEntryScreen(
//                navigateBack = { navController.popBackStack() },
//                onNavigateUp = { navController.navigateUp() }
//            )
//        }
//    }
//}


sealed class DetailsScreen(val route: String) {
    object Addition : DetailsScreen(route = "Addition")
    object Update : DetailsScreen(route = "Update")
}