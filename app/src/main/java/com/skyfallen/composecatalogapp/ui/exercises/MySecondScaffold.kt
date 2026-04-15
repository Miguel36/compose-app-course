package com.skyfallen.composecatalogapp.ui.exercises

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.compose.rememberNavController
import com.skyfallen.composecatalogapp.components.MyFab
import com.skyfallen.composecatalogapp.components.MyModalDrawer
import com.skyfallen.composecatalogapp.components.MyTopAppBar
import kotlinx.coroutines.launch

@Composable
fun MySecondScaffoldNavigationDrawer(drawerState: DrawerState, snackBarHostState: SnackbarHostState) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()

    MyModalDrawer(drawerState = drawerState, navController = navController) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { MyTopAppBar { scope.launch { drawerState.open() } } },
            snackbarHost = { SnackbarHost(hostState = snackBarHostState) },
            floatingActionButton = { MyFab() },
            floatingActionButtonPosition = FabPosition.End) { innerPadding ->
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(Color.White), contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Este es mi screen",
                    color = Color.Black,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.clickable {
                        scope.launch {
                            val result = snackBarHostState.showSnackbar(
                                message = "My Snackbar",
                                duration = SnackbarDuration.Long,
                                actionLabel = "Deshacer"
                            )

                            if (result == SnackbarResult.ActionPerformed) {
                                // el usuario pulsó en deshacer
                                Toast.makeText(
                                    context,
                                    "Que pasó muchachón",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                            else { /* El usuario dejó que se cerrara el SnackBar*/ }
                        }
                    }
                )
            }
        }
    }
}