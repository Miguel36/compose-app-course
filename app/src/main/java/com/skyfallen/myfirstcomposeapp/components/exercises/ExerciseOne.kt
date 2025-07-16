package com.skyfallen.myfirstcomposeapp.components.exercises

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Exercise One
 * Filas, Columnas y Cajas
 */

@Composable
fun RowsColumsAndBoxExercise(modifier: Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        Box(
            Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color.DarkGray),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Example 1")
        }
        Spacer(Modifier.height(10.dp))
        Row(Modifier
            .weight(1f)
            .fillMaxWidth()
            .background(Color.White)) {
            Box(
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Red),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Example 2")

            }
            Spacer(Modifier.width(10.dp))
            Box(
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Green),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Example 3")
            }
        }
        Spacer(Modifier.height(10.dp))
        Box(
            Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color.LightGray),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "Example 4")
        }
    }
}