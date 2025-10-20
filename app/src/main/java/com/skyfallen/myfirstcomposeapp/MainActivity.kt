package com.skyfallen.myfirstcomposeapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.skyfallen.myfirstcomposeapp.components.MyAdvancedList
import com.skyfallen.myfirstcomposeapp.components.MyBasicList
import com.skyfallen.myfirstcomposeapp.components.MyCustomDialog
import com.skyfallen.myfirstcomposeapp.components.MyFab
import com.skyfallen.myfirstcomposeapp.components.MyGridList
import com.skyfallen.myfirstcomposeapp.components.MyModalDrawer
import com.skyfallen.myfirstcomposeapp.components.MyNavigationBar
import com.skyfallen.myfirstcomposeapp.components.MyScrollList
import com.skyfallen.myfirstcomposeapp.components.MyTopAppBar
import com.skyfallen.myfirstcomposeapp.components.advanced.MyDerivedStateOf
import com.skyfallen.myfirstcomposeapp.components.advanced.MyInteractionSource
import com.skyfallen.myfirstcomposeapp.components.advanced.MyLaunchedEffect
import com.skyfallen.myfirstcomposeapp.components.animations.FullAnimatedAsState
import com.skyfallen.myfirstcomposeapp.components.animations.MyAnimatedContent
import com.skyfallen.myfirstcomposeapp.components.animations.MyAnimatedContentSize
import com.skyfallen.myfirstcomposeapp.components.animations.MyAnimatedVisibility
import com.skyfallen.myfirstcomposeapp.components.animations.MyInfiniteTransition
import com.skyfallen.myfirstcomposeapp.components.model.PokemonCombat
import com.skyfallen.myfirstcomposeapp.components.navigation.NavigationWrapper
import com.skyfallen.myfirstcomposeapp.login.Greeting
import com.skyfallen.myfirstcomposeapp.ui.theme.MyFirstComposeAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

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

                var showDialog by remember { mutableStateOf(false) }
                val pokemonCombat = PokemonCombat("Pikachu", "Gengar")
                MyCustomDialog(
                    pokemonCombat = pokemonCombat,
                    showDialog = showDialog,
                    onStartCombat = {
                        showDialog = false
                        TODO("Add the logic to execute when the combat button is clicked")
                    },
                    onDismissDialog = { showDialog = false }
                )
                //NavigationWrapper()
                //MyAnimatedVisibility()
                //FullAnimatedAsState()
                //MyAnimatedContent()
                //MyAnimatedContentSize()
                //MyInfiniteTransition()

                MyModalDrawer(drawerState = drawerState) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = { MyTopAppBar { scope.launch { drawerState.open() } } },
                        snackbarHost = { SnackbarHost(hostState = snackBarHostState) },
                        floatingActionButton = { MyFab { showDialog = true } },
                        floatingActionButtonPosition = FabPosition.End,
                        bottomBar = { MyNavigationBar() })
                    {
                        innerPadding -> Content(innerPadding, scope, snackBarHostState)
                    }
                }
            }
        }
    }

    @Composable
    private fun Content(
        innerPadding: PaddingValues,
        scope: CoroutineScope,
        snackBarHostState: SnackbarHostState
    ) {
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Este es mi screen",
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
                                this@MainActivity,
                                "Que pasó muchachón",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else { /* El usuario dejo que se cerrara el SnackBar*/
                        }
                    }
                }
            )
            //Spacer(Modifier.height(20.dp))
            //MyInteractionSource()
            //MyLaunchedEffect {  }
            //MyDerivedStateOf()
            //MyAdvancedList()
            //MyScrollList()
            MyGridList()
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