package com.skyfallen.myfirstcomposeapp.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import com.skyfallen.myfirstcomposeapp.components.MyCustomDialog
import com.skyfallen.myfirstcomposeapp.components.MyFab
import com.skyfallen.myfirstcomposeapp.components.MyModalDrawer
import com.skyfallen.myfirstcomposeapp.components.MyNavigationBar
import com.skyfallen.myfirstcomposeapp.components.MyTopAppBar
import com.skyfallen.myfirstcomposeapp.components.model.PokemonCombat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val snackBarHostState = remember { SnackbarHostState() }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope() // Se crea corroutina para gestionar en un hilo secundario un proceso
    var showDialog by remember { mutableStateOf(false) }

    val pokemonCombat = PokemonCombat("Pikachu", "Gengar")
    if (showDialog) {
        MyCustomDialog(
            pokemonCombat = pokemonCombat,
            onStartCombat = {
                showDialog = false
                TODO("Add the logic to execute when the combat button is clicked")
            },
            onDismissDialog = { showDialog = false }
        )
    }

    MyModalDrawer(drawerState = drawerState) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { MyTopAppBar { scope.launch { drawerState.open() } } },
            snackbarHost = { SnackbarHost(hostState = snackBarHostState) },
            floatingActionButton = { MyFab { showDialog = true } },
            floatingActionButtonPosition = FabPosition.End,
            bottomBar = { MyNavigationBar() })
        { innerPadding ->
            Content(innerPadding, scope, snackBarHostState)
        }
    }
}

@Composable
private fun Content(innerPadding: PaddingValues, scope: CoroutineScope, snackBarHostState: SnackbarHostState) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
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
                        Toast.makeText(context, "Que pasó muchachón", Toast.LENGTH_SHORT).show()
                    }
                    else { /* El usuario dejo que se cerrara el SnackBar*/ }
                }
            }
        )
    }
}