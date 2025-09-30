package com.skyfallen.myfirstcomposeapp.components.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.skyfallen.myfirstcomposeapp.components.navigation.screens.HomeScreen
import com.skyfallen.myfirstcomposeapp.components.navigation.screens.LoginScreen

@Composable
fun NavigationWrapper(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Login) {
        composable<Login> {
            LoginScreen(navigateTo = { navController.navigate(Home) })
        }

        composable<Home> {
            HomeScreen(navigateBack = { navController.popBackStack() })
        }
    }
}