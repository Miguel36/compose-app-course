package com.skyfallen.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MyRadioButton(modifier: Modifier) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            false,
            onClick = {},
            enabled = false,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.DarkGray,
                unselectedColor = Color.Black,
                disabledSelectedColor = Color.Red,
                disabledUnselectedColor = Color.Cyan
            )
        )
        Text(text = "Ejemplo 1")
    }
}