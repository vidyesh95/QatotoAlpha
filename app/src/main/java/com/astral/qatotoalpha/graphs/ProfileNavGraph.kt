package com.astral.qatotoalpha.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.astral.qatotoalpha.feature.profile.presentation.AccountSettingsScreen
import com.astral.qatotoalpha.feature.profile.presentation.ProfileScreen
import com.astral.qatotoalpha.util.Screen

fun NavGraphBuilder.profileNavigationGraph(navController: NavHostController) {
    navigation(
        route = Graph.PROFILE_GRAPH,
        startDestination = Screen.ProfileScreen.route
    ) {
        composable(route = Screen.ProfileScreen.route) {
            ProfileScreen(navController = navController)
        }
        composable(route = Screen.AccountSettingsScreen.route) {
            AccountSettingsScreen(navController = navController)
        }
        authNavigationGraph(navController = navController)
    }
}
/*
@Composable
fun ProfileNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.PROFILE_GRAPH,
        startDestination = Screen.ProfileScreen.route
    ) {
        composable(route = Screen.ProfileScreen.route) {
            ProfileScreen()
        }
        authNavigationGraph(navController = navController)
    }
}*/
