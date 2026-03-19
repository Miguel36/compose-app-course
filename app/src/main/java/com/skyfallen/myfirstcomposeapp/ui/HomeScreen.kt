package com.skyfallen.myfirstcomposeapp.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
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
import androidx.navigation.NavHostController
import com.skyfallen.myfirstcomposeapp.components.MyCustomDialog
import com.skyfallen.myfirstcomposeapp.components.MyFab
import com.skyfallen.myfirstcomposeapp.components.model.PokemonCombat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(navController: NavHostController, snackBarHostState: SnackbarHostState, setFab: (@Composable () -> Unit) -> Unit) {
    var showDialog by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
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

    DisposableEffect(Unit) {
        setFab {
            MyFab { showDialog = true }
        }
        onDispose { setFab {} }
    }

    Content(scope = scope, snackBarHostState = snackBarHostState)
}

@Composable
private fun Content(scope: CoroutineScope, snackBarHostState: SnackbarHostState) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
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