package com.skyfallen.myfirstcomposeapp.ui.concepts.navigation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.skyfallen.myfirstcomposeapp.ui.concepts.navigation.model.SettingModel

private const val DARK_MODE_ID = 1

@Composable
fun DetailScreen(name: String, navigateToSettings: (SettingModel) -> Unit) {
    val settings = SettingModel(DARK_MODE_ID, true)

    Column(
        Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Detail Screen", fontSize = 40.sp)
            Text(text = "Hello! $name", fontSize = 30.sp, color = Color.Blue)
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { navigateToSettings(settings) }) { Text("Settings") }
            Button(onClick = { }) { Text(text = "Back") }
        }
    }
}