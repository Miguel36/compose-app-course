package com.skyfallen.composecatalogapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import com.skyfallen.composecatalogapp.ui.navigation.MainNavigationWrapper
import com.skyfallen.composecatalogapp.ui.theme.ComposeCatalogAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeCatalogAppTheme {
                AppNavigation()
            }
        }
    }

    @Composable
    private fun AppNavigation() {
        MainNavigationWrapper()
    }
}
