package com.skyfallen.myfirstcomposeapp.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.skyfallen.myfirstcomposeapp.components.MyModalDrawer
import com.skyfallen.myfirstcomposeapp.components.MyNavigationBar
import com.skyfallen.myfirstcomposeapp.components.MyTopAppBar
import com.skyfallen.myfirstcomposeapp.components.layout.MyBox
import com.skyfallen.myfirstcomposeapp.components.navigation.NavigationWrapper
import com.skyfallen.myfirstcomposeapp.ui.HomeScreen
import kotlinx.coroutines.launch

@Composable
fun MainNavigationWrapper() {
    val snackBarHostState = remember { SnackbarHostState() }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope() // Se crea corroutina para gestionar en un hilo secundario un proceso
    var fabView by remember { mutableStateOf<(@Composable () -> Unit)?>(null) }

    val navController = rememberNavController()

    MyModalDrawer(drawerState = drawerState, navController = navController) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { MyTopAppBar { scope.launch { drawerState.open() } } },
            snackbarHost = { SnackbarHost(hostState = snackBarHostState) },
            floatingActionButton = { fabView?.invoke() },
            floatingActionButtonPosition = FabPosition.End,
            bottomBar = { MyNavigationBar() })
        { innerPadding ->

            NavHost(navController = navController, startDestination = Home, modifier = Modifier.padding(innerPadding)) {
                composable<Home> {
                    HomeScreen(navController = navController, snackBarHostState = snackBarHostState) { fabView = it }
                }
                composable<NavigationWrapperExample> {
                    NavigationWrapper()
                }
                composable<MyBoxLayout> {
                    MyBox()
                }
            }
        }
    }


}