package com.skyfallen.myfirstcomposeapp.components.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.skyfallen.myfirstcomposeapp.components.navigation.model.SettingModel
import com.skyfallen.myfirstcomposeapp.components.navigation.screens.DetailScreen
import com.skyfallen.myfirstcomposeapp.components.navigation.screens.HomeScreen
import com.skyfallen.myfirstcomposeapp.components.navigation.screens.LoginScreen
import com.skyfallen.myfirstcomposeapp.components.navigation.screens.SettingsScreen
import com.skyfallen.myfirstcomposeapp.components.navigation.types.createNavType
import com.skyfallen.myfirstcomposeapp.components.navigation.types.settingModelType
import kotlin.reflect.typeOf

@Composable
fun NavigationWrapper(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Login) {
        composable<Login> {
            LoginScreen(navigateTo = { navController.navigate(Home) })
        }

        composable<Home> {
            HomeScreen(
                navigateBack = { navController.popBackStack() },
                navigateToDetail = { name, isUser -> navController.navigate(Detail(name, isUser)) })
        }

        composable<Detail> { navBackStackEntry ->
            val args = navBackStackEntry.toRoute<Detail>()
            //args.isUser
            DetailScreen(
                name = args.name,
                navigateToSettings = { navController.navigate(Settings(it)) })
        }

        composable<Settings>(typeMap = mapOf(typeOf<SettingModel>() to createNavType<SettingModel>())) { navStackEntry ->
            val settingsArgs = navStackEntry.toRoute<Settings>()
            SettingsScreen(settings = settingsArgs.settingModel)
        }
    }
}