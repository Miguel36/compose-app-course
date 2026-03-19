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
import com.skyfallen.myfirstcomposeapp.components.advanced.MyDerivedStateOf
import com.skyfallen.myfirstcomposeapp.components.advanced.MyInteractionSource
import com.skyfallen.myfirstcomposeapp.components.advanced.MyLaunchedEffect
import com.skyfallen.myfirstcomposeapp.components.exercises.ConstraintLayoutExercise
import com.skyfallen.myfirstcomposeapp.components.exercises.RowsColumnsAndBoxExercise
import com.skyfallen.myfirstcomposeapp.components.exercises.ScaffoldOnlyWithBottomBar
import com.skyfallen.myfirstcomposeapp.components.layout.BasicConstraintLayout
import com.skyfallen.myfirstcomposeapp.components.layout.ConstraintBarrier
import com.skyfallen.myfirstcomposeapp.components.layout.ConstraintChain
import com.skyfallen.myfirstcomposeapp.components.layout.ConstraintExampleGuide
import com.skyfallen.myfirstcomposeapp.components.layout.MyBox
import com.skyfallen.myfirstcomposeapp.components.layout.MyColum
import com.skyfallen.myfirstcomposeapp.components.layout.MyComplexLayout
import com.skyfallen.myfirstcomposeapp.components.layout.MyRow
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

                composable<MyBoxLayout> { MyBox() }
                composable<MyColumnLayout> { MyColum() }
                composable<MyMixedLayout> { MyComplexLayout() }
                composable<MyRowLayout> { MyRow() }

                composable<MyBasicConstraintLayout> { BasicConstraintLayout() }
                composable<MyGuideLineConstraintLayout> { ConstraintExampleGuide() }
                composable<MyBarrierConstraintLayout> { ConstraintBarrier() }
                composable<MyChainConstraintLayout> { ConstraintChain() }

                composable<RowsColumnsExercise> { RowsColumnsAndBoxExercise() }
                composable<ConstraintsExercise> { ConstraintLayoutExercise() }

                composable<BottomBarScaffold> { ScaffoldOnlyWithBottomBar(snackBarHostState) }

                composable<LaunchedEffectExample> { MyLaunchedEffect {} }
                composable<InteractionSourceExample> { MyInteractionSource() }
                composable<DerivedStateOfExample> { MyDerivedStateOf() }
            }
        }
    }


}