package com.skyfallen.composecatalogapp.ui.concepts.navigation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(navigateBack: () -> Unit, navigateToDetail: (String, Boolean) -> Unit) {
    var text by remember { mutableStateOf("") }

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text("Home Screen", fontSize = 40.sp)

        Row(Modifier.padding(horizontal = 16.dp)) {
            TextField(
                value = text,
                onValueChange = { text = it },
                Modifier.padding(end = 8.dp),
                label = { Text("Ingresa tu nombre") })

            Button(onClick = { navigateToDetail(text, true) }) {
                Text(
                    text = "Send",
                    fontWeight = FontWeight.SemiBold
                )
            }
        }

        Button(onClick = { navigateBack() }) {
            Text(text = "Back")
        }
    }
}