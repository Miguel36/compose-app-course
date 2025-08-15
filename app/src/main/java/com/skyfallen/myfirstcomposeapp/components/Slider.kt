package com.skyfallen.myfirstcomposeapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SliderState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySliderAdvanced(modifier: Modifier) {
    val colors = SliderDefaults.colors(
        thumbColor = Color.DarkGray,
        disabledThumbColor = Color.Black,
        disabledActiveTrackColor = Color.DarkGray,
        disabledInactiveTrackColor = Color.LightGray
    )

    var stringState by remember { mutableStateOf(":)") }
    val state = remember {
        SliderState(
            value = 5f,
            valueRange = 0f..10f,
            steps = 9, // number of intervals
            onValueChangeFinished = { stringState = "Feliz" }
        )
    }

    Column(modifier = modifier) {
        Slider(state, colors = colors, enabled = true, thumb = {
            Box(
                Modifier
                    .width(5.dp)
                    .height(32.dp)
                    .background(
                        Color.DarkGray
                    )
            )
        })
        Text(stringState)
    }
}