package com.skyfallen.myfirstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import com.skyfallen.myfirstcomposeapp.ui.navigation.MainNavigationWrapper
import com.skyfallen.myfirstcomposeapp.ui.theme.MyFirstComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstComposeAppTheme {
                AppNavigation()
            }
        }
    }

    @Composable
    private fun AppNavigation() {
        MainNavigationWrapper()
    }
}
