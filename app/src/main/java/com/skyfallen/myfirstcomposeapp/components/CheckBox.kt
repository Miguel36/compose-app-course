package com.skyfallen.myfirstcomposeapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import com.skyfallen.myfirstcomposeapp.components.state.CheckBoxData

@Composable
fun MyCheckBox(modifier: Modifier) {
    /**
     * @switchState, variable de estado que actualizará y establecerá el valor de chequeado en el CheckBox
     */
    var switchState by remember { mutableStateOf(true) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                switchState,
                onCheckedChange = { switchState = it },
                enabled = true,
                colors = CheckboxDefaults.colors(
                    checkmarkColor = Color.Yellow,
                    uncheckedColor = Color.Blue
                )
            )
            Spacer(Modifier.width(2.dp))
            Text(text = "Acepto los terminos y condiciones")
        }
    }
}

@Composable
fun ParentCheckBoxes(modifier: Modifier) {
    var states by remember { mutableStateOf(
        listOf(
            CheckBoxData("terms", "Aceptar los terminos y condiciones"),
            CheckBoxData("newsletter", "Recibir newsletter", true),
            CheckBoxData("updates", "Recibir actualizaciones")
        )
    )}

    Column(modifier = modifier.fillMaxSize()) {
        states.forEach { checkBoxItem ->
            MyCheckBoxWithText(checkBoxItem)  {
                /**
                 * Este es el lambda que estamos mandando como argumento al composable MyCheckBoxWithText()
                 * el cual lo recibe mediante el parametro onCheckedChanged
                 */

                states = states.map {
                    if (checkBoxItem.id == it.id)
                        checkBoxItem.copy(checked = !checkBoxItem.checked, label = "Heyyy Man")
                    else it
                }
            }
        }
    }

}

@Composable
fun MyCheckBoxWithText(checkBoxData: CheckBoxData, onCheckedChanged: (CheckBoxData) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checkBoxData.checked,
            onCheckedChange = { onCheckedChanged(checkBoxData) },
            enabled = true,
            colors = CheckboxDefaults.colors(
                checkmarkColor = Color.Yellow,
                uncheckedColor = Color.Blue
            )
        )
        Spacer(Modifier.width(2.dp))
        Text(text = checkBoxData.label)
    }
}

@Composable
fun ThreeStateCheckBox(modifier: Modifier) {
    var parentState by remember { mutableStateOf(ToggleableState.Off) }
    var child1 by remember { mutableStateOf(false) }
    var child2 by remember { mutableStateOf(false) }

    LaunchedEffect(child1, child2) {
        parentState = when {
            child1 && child2 -> ToggleableState.On
            !child1 && !child2 -> ToggleableState.Off
            else -> ToggleableState.Indeterminate
        }
    }

    Column(modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            TriStateCheckbox(parentState, onClick = {
                val newState = parentState != ToggleableState.On
                child1 = newState
                child2 = child1
            })
            Text(text = "Seleccionar todo")
        }
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(horizontal = 18.dp)) {
            Checkbox(child1, {child1 = it})
            Text(text = "Ejemplo 1")
        }
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(horizontal = 18.dp)) {
            Checkbox(child2, {child2 = it})
            Text(text = "Ejemplo 2")
        }
    }
}