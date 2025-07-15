package com.skyfallen.myfirstcomposeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun MyRow(modifier: Modifier) {
    Row(modifier = modifier.fillMaxSize()) {
        Text(text = "Hello 1", modifier = Modifier.weight(1f).background(Color.Yellow))
        Text(text = "Hello 2", modifier = Modifier.weight(1f).background(Color.Blue))
        Text(text = "Hello 3", modifier = Modifier.weight(1f).background(Color.Red))
    }
}