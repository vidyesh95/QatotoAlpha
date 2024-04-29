package com.astral.qatotoalpha.graphs

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.astral.qatotoalpha.feature.anime.presentation.AnimeScreen
import com.astral.qatotoalpha.feature.auth.presentation.signin.SignInState
import com.astral.qatotoalpha.feature.auth.presentation.signin.SignInViewModel
import com.astral.qatotoalpha.feature.create.presentaion.CreateScreen
import com.astral.qatotoalpha.feature.home.presentation.HomeScreen
import com.astral.qatotoalpha.feature.shorts.presentation.ShortsScreen
import com.astral.qatotoalpha.feature.store.presentation.StoreScreen
import com.astral.qatotoalpha.util.NavigationBarScreen

@Composable
fun MainNavigationGraph(
    navController: NavHostController,
    innerPadding: PaddingValues,
    signInViewModel: SignInViewModel,
    signInState: SignInState,
    onContinueWithGoogleClick: () -> Unit
) {
    NavHost(
        navController = navController,
        route = Graph.MAIN_GRAPH,
        startDestination = NavigationBarScreen.HomeScreen.route,
        modifier = Modifier.padding(innerPadding)
    ) {
        composable(route = NavigationBarScreen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(route = NavigationBarScreen.AnimeScreen.route) {
            AnimeScreen(navController = navController)
        }
        composable(route = NavigationBarScreen.CreateScreen.route) {
            CreateScreen(navController = navController)
        }
        composable(route = NavigationBarScreen.StoreScreen.route) {
            StoreScreen(navController = navController)
        }
        composable(route = NavigationBarScreen.ShortsScreen.route) {
            ShortsScreen()
        }
        profileNavigationGraph(
            navController = navController,
            signInViewModel = signInViewModel,
            signInState = signInState,
            onContinueWithGoogleClick = onContinueWithGoogleClick
        )
    }
}
