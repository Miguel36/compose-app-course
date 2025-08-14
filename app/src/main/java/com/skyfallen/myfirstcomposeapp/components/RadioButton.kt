package com.skyfallen.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

@Composable
fun RadioButtonList(modifier: Modifier) {
    var selectedItemText by remember { mutableStateOf("") }

    Column(modifier = modifier) {
        RadioButtonComponent("Opción 1", selectedItemText) { selectedItemText = it }
        RadioButtonComponent("Opción 2", selectedItemText) { selectedItemText = it }
        RadioButtonComponent("Opción 3", selectedItemText) { selectedItemText = it }
    }

}

@Composable
fun RadioButtonComponent(
    itemText: String,
    selectedItemText: String,
    onItemSelected: (String) -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(selected = itemText == selectedItemText, onClick = { onItemSelected(itemText) })
        Text(text = itemText)
    }
}