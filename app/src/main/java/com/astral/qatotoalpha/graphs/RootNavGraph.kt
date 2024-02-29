package com.astral.qatotoalpha.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.astral.qatotoalpha.feature.firsttime.presentation.FirstScreen
import com.astral.qatotoalpha.feature.navbar.presentation.MainScreen
import com.astral.qatotoalpha.util.FirstTimeScreen

@Composable
fun RootNavigationGraph(navController: NavHostController, isContinueAccepted: Boolean?) {
    NavHost(
        navController = navController,
        route = Graph.ROOT_GRAPH,
        startDestination = if (isContinueAccepted == false) {
            FirstTimeScreen.FirstScreen.route
        } else {
            FirstTimeScreen.MainScreen.route
        }
    ) {
        composable(route = FirstTimeScreen.FirstScreen.route) {
            FirstScreen(navController = navController)
        }
        composable(route = FirstTimeScreen.MainScreen.route) {
            MainScreen()
        }
    }
}

object Graph {
    const val ROOT_GRAPH = "root_graph"
    const val MAIN_GRAPH = "main_nav_graph"
    const val AUTH_GRAPH = "auth_nav_graph"
}
