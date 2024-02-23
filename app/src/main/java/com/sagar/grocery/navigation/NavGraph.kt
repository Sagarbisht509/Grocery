package com.sagar.grocery.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sagar.grocery.Screen.Cart
import com.sagar.grocery.Screen.Home
import com.sagar.grocery.Screen.Profile

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Destinations.Home.route
    ) {
        composable(Destinations.Home.route) {
            Home()
        }
        composable(Destinations.Cart.route) {
            Cart()
        }
        composable(Destinations.Profile.route) {
            Profile()
        }
    }
}