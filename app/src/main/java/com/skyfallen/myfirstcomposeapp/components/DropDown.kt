package com.skyfallen.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.skyfallen.myfirstcomposeapp.R

@Composable
fun MyDropDownItem(modifier: Modifier) {
    Column(modifier = modifier) {
        DropdownMenuItem(
            modifier = Modifier.fillMaxWidth(),
            text = { Text(text = "Ejemplo 1", modifier = Modifier.padding(start = 4.dp), fontWeight = FontWeight.SemiBold) },
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