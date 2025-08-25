package com.skyfallen.myfirstcomposeapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.skyfallen.myfirstcomposeapp.components.MyTopAppBar
import com.skyfallen.myfirstcomposeapp.login.Greeting
import com.skyfallen.myfirstcomposeapp.ui.theme.MyFirstComposeAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstComposeAppTheme {
                val snackbarHostState = remember { SnackbarHostState() }

                // Se crea corroutina para gestionar en un hilo secundario un proceso
                val scope = rememberCoroutineScope()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { MyTopAppBar() },
                    snackbarHost = { SnackbarHost(hostState = snackbarHostState) }) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                            .background(Color.DarkGray), contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Este es mi screen",
                            color = Color.White,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.clickable {
                                scope.launch {
                                    val result = snackbarHostState.showSnackbar(
                                        message = "My Snackbar",
                                        duration = SnackbarDuration.Long,
                                        actionLabel = "Deshacer"
                                    )

                                    if (result == SnackbarResult.ActionPerformed) {
                                        // el usuario pulsó en deshacer
                                        Toast.makeText(this@MainActivity, "Que pasó muchachón", Toast.LENGTH_SHORT).show()
                                    }
                                    else { /* El usuario dejo que se cerrara el SnackBar*/ }
                                }
                            }
                        )
                    }
                }
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