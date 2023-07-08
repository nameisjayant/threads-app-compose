package com.nameisjayant.threadsapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.nameisjayant.threadsapp.bottom_bar.BottomBarItems
import com.nameisjayant.threadsapp.features.screens.HomeScreen
import com.nameisjayant.threadsapp.features.screens.NotificationScreen
import com.nameisjayant.threadsapp.features.screens.PostScreen
import com.nameisjayant.threadsapp.features.screens.ProfileScreen
import com.nameisjayant.threadsapp.features.screens.SearchScreen


@Composable
fun AppNavigation(
    navHostController: NavHostController
) {

    NavHost(navController = navHostController, startDestination = BottomBarItems.Home.route) {
        composable(BottomBarItems.Home.route) {
            HomeScreen()
        }
        composable(BottomBarItems.Search.route) {
            SearchScreen()
        }
        composable(BottomBarItems.Post.route) {
            PostScreen()
        }
        composable(BottomBarItems.Notification.route) {
            NotificationScreen()
        }
        composable(BottomBarItems.Profile.route) {
            ProfileScreen()
        }
    }

}