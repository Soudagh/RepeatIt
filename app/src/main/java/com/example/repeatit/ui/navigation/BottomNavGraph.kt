package com.example.repeatit.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.repeatit.BottomBarScreen
import com.example.repeatit.ui.dictionary.DictScreen
import com.example.repeatit.ui.profile.ProfileScreen
import com.example.repeatit.ui.trainings.TrainScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Dictionary.route) {
            composable(route = BottomBarScreen.Dictionary.route) {
                DictScreen()
            }
            composable(route = BottomBarScreen.Training.route) {
                TrainScreen()
            }
            composable(route = BottomBarScreen.Profile.route) {
                ProfileScreen()
            }
    }
}