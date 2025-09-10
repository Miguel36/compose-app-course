package com.skyfallen.myfirstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.skyfallen.myfirstcomposeapp.components.MyCustomDialog
import com.skyfallen.myfirstcomposeapp.components.exercises.MySecondScaffoldNavigationDrawer
import com.skyfallen.myfirstcomposeapp.components.model.PokemonCombat
import com.skyfallen.myfirstcomposeapp.login.Greeting
import com.skyfallen.myfirstcomposeapp.ui.theme.MyFirstComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstComposeAppTheme {
                val snackBarHostState = remember { SnackbarHostState() }
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

                // Se crea corroutina para gestionar en un hilo secundario un proceso
                val scope = rememberCoroutineScope()

                var showDialog by remember { mutableStateOf(true) }
                val pokemonCombat = PokemonCombat("Pikachu", "Gengar")
                MyCustomDialog(pokemonCombat = pokemonCombat, showDialog = showDialog) {
                    showDialog = false
                }

                MySecondScaffoldNavigationDrawer(drawerState, scope, snackBarHostState, this@MainActivity)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyFirstComposeAppTheme {
        Greeting("Android")
    }
}