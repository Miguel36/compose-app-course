package com.skyfallen.myfirstcomposeapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.skyfallen.myfirstcomposeapp.components.layout.MyBox
import com.skyfallen.myfirstcomposeapp.components.navigation.NavigationWrapper
import com.skyfallen.myfirstcomposeapp.ui.HomeScreen

@Composable
fun MainNavigationWrapper() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Home) {
        composable<Home> {
            HomeScreen(navController = navController)
        }
        composable<NavigationWrapperExample> {
            NavigationWrapper()
        }
        composable<MyBoxLayout> {
            MyBox()
        }
    }
}