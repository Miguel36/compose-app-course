package com.skyfallen.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MySlider(modifier: Modifier) {
    var sliderValue by remember { mutableFloatStateOf(0.5f) }
    Column(modifier = modifier.padding(horizontal = 24.dp)) {
        Slider(
            value = sliderValue,
            onValueChange = { sliderValue = it },
            enabled = true,
            colors = SliderDefaults.colors(
                thumbColor = Color.DarkGray,
                disabledThumbColor = Color.Black,
                disabledActiveTrackColor = Color.DarkGray,
                disabledInactiveTrackColor = Color.LightGray
            )
        )
        Text(text = sliderValue.toString())
    }
}