package com.skyfallen.composecatalogapp.ui.concepts.navigation.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(navigateTo: () -> Unit) {
    var showView by remember { mutableStateOf(false) }

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text("Login Screen", fontSize = 40.sp)
        Button(onClick = { navigateTo() }) {
            Text(text = "Next")
        }
        // Simulates navigating to another view without changing the view
        Button(onClick = { showView = true }) {
            Text(text = "Navigate to subview")
        }
    }

    if (showView) {
        BackHandler {
            showView = false
        }

        Box(Modifier.fillMaxSize().background(Color.Blue.copy(0.2f)))
    }
}