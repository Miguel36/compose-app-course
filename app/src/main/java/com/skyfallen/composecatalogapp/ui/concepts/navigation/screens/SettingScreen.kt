package com.skyfallen.composecatalogapp.ui.concepts.navigation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.skyfallen.composecatalogapp.ui.concepts.navigation.model.SettingModel

@Composable
fun SettingsScreen(settings: SettingModel, navigateToLogin: () -> Unit) {
    Column(
        Modifier
            .fillMaxSize()
            .background(if (settings.darkMode) Color.Black else Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            text = "Settings Screen",
            fontSize = 40.sp,
            textAlign = TextAlign.Center,
            color = if (settings.darkMode) Color.White else Color.Black
        )
        Text(
            text = "DarkMode: ${settings.darkMode}",
            fontSize = 30.sp,
            color = if (settings.darkMode) Color.White else Color.Black
        )
        Button(onClick = { navigateToLogin() }) { Text(text = "Back To Home") }
    }
}