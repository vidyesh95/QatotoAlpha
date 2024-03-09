package com.astral.qatotoalpha.graphs

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.astral.qatotoalpha.feature.anime.presentation.AnimeScreen
import com.astral.qatotoalpha.feature.create.presentaion.CreateScreen
import com.astral.qatotoalpha.feature.home.presentation.HomeScreen
import com.astral.qatotoalpha.feature.shorts.presentation.ShortsScreen
import com.astral.qatotoalpha.feature.store.presentation.StoreScreen
import com.astral.qatotoalpha.util.NavigationBarScreen

@Composable
fun MainNavigationGraph(navController: NavHostController, innerPadding: PaddingValues) {
    NavHost(
        navController = navController,
        route = Graph.MAIN_GRAPH,
        startDestination = NavigationBarScreen.HomeScreen.route,
        modifier = Modifier.padding(innerPadding)
    ) {
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
        composable(route = NavigationBarScreen.AnimeScreen.route) {
            ShortsScreen()
        }
    }
}
