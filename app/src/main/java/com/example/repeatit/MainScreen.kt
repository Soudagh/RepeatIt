package com.example.repeatit

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.DrawerValue
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.repeatit.ui.navigation.Graph
import com.example.repeatit.ui.navigation.HomeNavGraph
import com.example.repeatit.ui.theme.RepeatItTheme


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController = rememberNavController()) {
    RepeatItTheme {
        val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val homeRoutesList = listOf(
            BottomBarScreen.Dictionary.route,
            BottomBarScreen.Profile.route,
            BottomBarScreen.Training.route
        )
        Scaffold(
            bottomBar = {
                if (currentRoute in homeRoutesList) {
                    BottomBar(navController = navController)
                }
            },
            floatingActionButton = {
                if (currentRoute == BottomBarScreen.Dictionary.route) {
                    FloatingActionButton(
                        onClick = { navController.navigate(Graph.MODIFICATION) },
                    ) {
                        androidx.compose.material3.Icon(imageVector = Icons.Default.Add, contentDescription = null)
                    }
                }
            }

        ) {
            HomeNavGraph(navController = navController)
        }
    }
}


@Composable
fun BottomBar(navController: NavHostController, modifier: Modifier = Modifier) {
    val screens = listOf(
        BottomBarScreen.Dictionary,
        BottomBarScreen.Training,
        BottomBarScreen.Profile,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    BottomNavigation(
        modifier = modifier,
        backgroundColor = MaterialTheme.colorScheme.background,
    ) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = stringResource(screen.resourceId))
        },
        icon = {
            Icon(
                painter = painterResource(id = screen.iconId),
                contentDescription = null,
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        selectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),

        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        }
    )
}



