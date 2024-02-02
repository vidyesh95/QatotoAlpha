package com.astral.qatotoalpha.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LiveTv
import androidx.compose.material.icons.filled.LocalMall
import androidx.compose.material.icons.filled.MobileScreenShare
import androidx.compose.material.icons.filled.VideoCall
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LiveTv
import androidx.compose.material.icons.outlined.LocalMall
import androidx.compose.material.icons.outlined.MobileScreenShare
import androidx.compose.material.icons.outlined.VideoCall
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationBarScreen(
    val route: String,
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasCartItem: Boolean = false,
    val badgeCount: Int? = null
) {
    object HomeScreen : NavigationBarScreen(
        route = "home_screen",
        title = "Home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home
    )

    object AnimeScreen : NavigationBarScreen(
        route = "anime_screen",
        title = "Anime",
        selectedIcon = Icons.Filled.LiveTv,
        unselectedIcon = Icons.Outlined.LiveTv
    )

    object CreateScreen : NavigationBarScreen(
        route = "create_screen",
        title = "Create",
        selectedIcon = Icons.Filled.VideoCall,
        unselectedIcon = Icons.Outlined.VideoCall
    )

    object StoreScreen : NavigationBarScreen(
        route = "store_screen",
        title = "Store",
        selectedIcon = Icons.Filled.LocalMall,
        unselectedIcon = Icons.Outlined.LocalMall,
        hasCartItem = true,
        badgeCount = 36
    )

    object ShortsScreen : NavigationBarScreen(
        route = "shorts_screen",
        title = "Shorts",
        selectedIcon = Icons.Filled.MobileScreenShare,
        unselectedIcon = Icons.Outlined.MobileScreenShare
    )
}
