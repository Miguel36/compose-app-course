package com.skyfallen.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupProperties
import com.skyfallen.myfirstcomposeapp.R

@Composable
fun MyDropDownMenu(modifier: Modifier) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = modifier.padding(start = 16.dp, top = 16.dp)) {
        Button(onClick = { expanded = true }) {
            Text(text = "+", fontSize = 18.sp)
        }

        // The closing of the DropdownMenu is handled automatically
        // when onDismissRequest updates the expanded state to false.
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            offset = DpOffset(10.dp, 16.dp),
            properties = PopupProperties(focusable = true, dismissOnClickOutside = false)
        ) {
            DropdownMenuItem(text = { Text(text = "Opción 1") }, onClick = { expanded = false })
            DropdownMenuItem(text = { Text(text = "Opción 2") }, onClick = { expanded = false })
            DropdownMenuItem(text = { Text(text = "Opción 3") }, onClick = { expanded = false })
            DropdownMenuItem(text = { Text(text = "Opción 4") }, onClick = { expanded = false })
        }
    }
}

@Composable
fun MyDropDownItem(modifier: Modifier) {
    Column(modifier = modifier) {
        DropdownMenuItem(
            modifier = Modifier.fillMaxWidth(),
            text = {
                Text(
                    text = "Ejemplo 1",
                    modifier = Modifier.padding(start = 4.dp),
                    fontWeight = FontWeight.SemiBold
                )
            },
            onClick = {},
            enabled = true,
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_smile),
                    contentDescription = ""
                )
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = ""
                )
            },
            colors = MenuDefaults.itemColors(
                textColor = Color.Red,
                trailingIconColor = Color.Red,
                disabledTextColor = Color.Black,
                disabledLeadingIconColor = Color.Gray,
                disabledTrailingIconColor = Color.Gray
            )
        )
    }
}