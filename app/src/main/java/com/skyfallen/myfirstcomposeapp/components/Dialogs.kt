@file:OptIn(ExperimentalMaterial3Api::class)

package com.skyfallen.myfirstcomposeapp.components

import android.icu.util.Calendar
import android.icu.util.TimeZone
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.TimePickerLayoutType
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
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
                usePlatformDefaultWidth = true, // This parameter makes the dialog fit the default size.
                decorFitsSystemWindows = true
            )
        )
}

@Composable
fun MyDateDialog(modifier: Modifier = Modifier) {
    var showDialog by remember { mutableStateOf(true) }

    val calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
    calendar.add(Calendar.DAY_OF_YEAR, +1)
    calendar.set(Calendar.MONTH, Calendar.SEPTEMBER)


    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = calendar.timeInMillis,
        yearRange = 2024..2026,
        initialDisplayMode = DisplayMode.Picker,
        // This function allows you to filter that dates are selectable in DatePicker
        selectableDates = object : SelectableDates {
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                val filterCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
                    .apply { timeInMillis = utcTimeMillis }
                val day = filterCalendar.get(Calendar.DAY_OF_MONTH)
                return day % 2 == 0
            }
        }
    )

    if (showDialog) {
        DatePickerDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                TextButton(onClick = {
                    showDialog = false
                    val result = datePickerState.selectedDateMillis
                    result?.let {
                        val newCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
                            .apply { timeInMillis = result }
                        val day = newCalendar.get(Calendar.DAY_OF_MONTH)
                        val month = newCalendar.get(Calendar.MONTH) + 1
                        Log.i("Fecha seleccionada", "Dia: $day, month: $month")
                    }
                }) {
                    Text(modifier = Modifier.padding(end = 8.dp), text = "Confirmar")
                }

            },
            shape = RoundedCornerShape(8)
        ) {
            DatePicker(datePickerState)
        }
    }
}

@Composable
fun MyTimePicker(modifier: Modifier = Modifier) {
    var showTimePicker by remember { mutableStateOf(true) }
    val timePickerState = rememberTimePickerState(
        initialHour = 6,
        initialMinute = 30,
        is24Hour = false
    )

    if (showTimePicker) {
        Dialog(onDismissRequest = { showTimePicker = false }) {
            Column(modifier = modifier
                .background(Color.White)
                .padding(24.dp)) {
                TimePicker(
                    timePickerState,
                    layoutType = TimePickerLayoutType.Vertical,
                    colors = TimePickerDefaults.colors(
                        clockDialColor = Color.Yellow.copy(0.45f),
                        clockDialSelectedContentColor = Color.White,
                        selectorColor = Color.Black,
                        clockDialUnselectedContentColor = Color.Black,
                        periodSelectorBorderColor = Color.Blue,
                        periodSelectorSelectedContentColor = Color.White,
                        periodSelectorSelectedContainerColor = Color.Black,
                        periodSelectorUnselectedContentColor = Color.Black,
                        timeSelectorSelectedContentColor = Color.White,
                        timeSelectorSelectedContainerColor = Color.Black,
                        timeSelectorUnselectedContentColor = Color.Black,
                        timeSelectorUnselectedContainerColor = Color.White
                    )
                )
            }
        }
    }
}