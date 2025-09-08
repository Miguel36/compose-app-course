@file:OptIn(ExperimentalMaterial3Api::class)

package com.skyfallen.myfirstcomposeapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy

@Composable
fun MyDialog(modifier: Modifier = Modifier) {
    var showDialog by remember { mutableStateOf(true) }

    if (showDialog)
        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = { Button(onClick = { showDialog = false }) { Text("Entendido") } },
            dismissButton = { TextButton(onClick = { showDialog = false }) { Text("Cancelar") } },
            text = { Text(text = "Esta es mi descripción") },
            title = { Text("Quieres realizar esta acción?") },
            icon = {
                Icon(
                    modifier = Modifier.size(40.dp),
                    imageVector = Icons.Default.Info,
                    contentDescription = ""
                )
            },
            shape = RoundedCornerShape(12.dp),
            containerColor = Color.White,
            iconContentColor = Color.Red.copy(0.7f),
            titleContentColor = Color.DarkGray,
            textContentColor = Color.Black,
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true,
                securePolicy = SecureFlagPolicy.SecureOn,
                usePlatformDefaultWidth = true, // This parameter will do that dialog fit the default size
                decorFitsSystemWindows = true
            )
        )
}

@Composable
fun MyDateDialog(modifier: Modifier = Modifier) {
    var showDialog by remember { mutableStateOf(true) }
    val datePickerState = rememberDatePickerState(yearRange = 2024..2025)

    if (showDialog) {
        DatePickerDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                Text(
                    modifier = Modifier.padding(end = 12.dp).clickable { showDialog = false },
                    text = "Confirmar"
                )
            },
            shape = RoundedCornerShape(8)
        ) {
            DatePicker(datePickerState)
        }
    }

}