package com.astral.qatotoalpha.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.astral.qatotoalpha.feature.anime.presentation.AnimeScreen
import com.astral.qatotoalpha.feature.create.presentaion.CreateScreen
import com.astral.qatotoalpha.feature.firsttime.presentation.FirstScreen
import com.astral.qatotoalpha.feature.home.presentation.HomeScreen
import com.astral.qatotoalpha.feature.navbar.presentation.MainScreen
import com.astral.qatotoalpha.feature.shorts.presentation.ShortsScreen
import com.astral.qatotoalpha.feature.store.presentation.StoreScreen
import com.astral.qatotoalpha.util.NavigationBarScreen
import com.astral.qatotoalpha.util.Screen

@Composable
fun RootNavigationGraph(navController: NavHostController, isContinueAccepted: Boolean?) {
    NavHost(
        navController = navController,
        route = Graph.ROOT_GRAPH,
        startDestination = if (isContinueAccepted == false) {
            Screen.FirstScreen.route
        } else {
            Screen.MainScreen.route
        }
    ) {
        composable(route = Screen.FirstScreen.route) {
            FirstScreen(navController = navController)
        }
        composable(route = Screen.MainScreen.route) {
            MainScreen()
        }
        composable(route = NavigationBarScreen.HomeScreen.route) {
            HomeScreen()
        }
        composable(route = NavigationBarScreen.AnimeScreen.route) {
            AnimeScreen()
        }
        composable(route = NavigationBarScreen.CreateScreen.route) {
            CreateScreen()
        }
        composable(route = NavigationBarScreen.StoreScreen.route) {
            StoreScreen()
        }
        composable(route = NavigationBarScreen.ShortsScreen.route) {
            ShortsScreen()
        }
        profileNavigationGraph(navController = navController)
        authNavigationGraph(navController = navController)
    }
}

object Graph {
    const val ROOT_GRAPH = "root_graph"
    const val MAIN_GRAPH = "main_nav_graph"
    const val PROFILE_GRAPH = "profile_nav_graph"
    const val AUTH_GRAPH = "auth_nav_graph"
}
