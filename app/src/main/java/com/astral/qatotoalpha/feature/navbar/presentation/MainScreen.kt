package com.astral.qatotoalpha.feature.navbar.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.astral.qatotoalpha.graphs.MainNavigationGraph
import com.astral.qatotoalpha.ui.theme.QatotoAlphaTheme
import com.astral.qatotoalpha.util.NavigationBarScreen

@Composable
fun MainScreen() {
    MainPage()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage() {
    QatotoAlphaTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val items = listOf(
                NavigationBarScreen.HomeScreen,
                NavigationBarScreen.AnimeScreen,
                NavigationBarScreen.CreateScreen,
                NavigationBarScreen.StoreScreen,
                NavigationBarScreen.ShortsScreen
            )
            val navController = rememberNavController()
            Scaffold(
                bottomBar = {
                    NavigationBar {
                        val navBackStackEntry by navController.currentBackStackEntryAsState()
                        val currentDestination = navBackStackEntry?.destination
                        items.forEach { screen ->
                            val selected = currentDestination?.hierarchy?.any {
                                it.route == screen.route
                            } == true
                            NavigationBarItem(
                                icon = {
                                    BadgedBox(
                                        badge = {
                                            if (screen.badgeCount != null && screen.badgeCount > 0) {
                                                Badge {
                                                    Text(text = screen.badgeCount.toString())
                                                }
                                            }
                                        }
                                    ) {
                                        Icon(
                                            imageVector = if (selected) screen.selectedIcon else screen.unselectedIcon,
                                            contentDescription = screen.title
                                        )
                                    }
                                },
                                label = { Text(screen.title) },
                                selected = selected,
                                onClick = {
                                    navController.navigate(screen.route) {
                                        // Pop up to the start destination of the graph to avoid
                                        // building up a large stack of destinations on the back stack
                                        // as users select items
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        // Avoid multiple copies of the same destination when
                                        // reselecting the same item
                                        launchSingleTop = true
                                        // Restore state when reselecting a previously selected item
                                        restoreState = true
                                    }
                                }
                            )
                        }
                    }
                }
            ) { innerPadding ->
                MainNavigationGraph(navController = navController, innerPadding = innerPadding)
            }
        }
    }
}

