package com.skyfallen.myfirstcomposeapp.components.exercises

import android.content.Context
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.skyfallen.myfirstcomposeapp.components.MyFab
import com.skyfallen.myfirstcomposeapp.components.MyModalDrawer
import com.skyfallen.myfirstcomposeapp.components.MyNavigationBar
import com.skyfallen.myfirstcomposeapp.components.MyTopAppBar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun MySecondScaffoldNavigationDrawer(
    drawerState: DrawerState,
    scope: CoroutineScope,
    snackBarHostState: SnackbarHostState,
    context: Context
) {
    MyModalDrawer(drawerState = drawerState) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { MyTopAppBar { scope.launch { drawerState.open() } } },
            snackbarHost = { SnackbarHost(hostState = snackBarHostState) },
            floatingActionButton = { MyFab() },
            floatingActionButtonPosition = FabPosition.End,
            bottomBar = { MyNavigationBar() }) { innerPadding ->
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
                            else { /* El usuario dejo que se cerrara el SnackBar*/ }
                        }
                    }
                )
            }
        }
    }
}