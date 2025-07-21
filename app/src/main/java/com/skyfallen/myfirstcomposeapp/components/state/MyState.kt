package com.skyfallen.myfirstcomposeapp.components.state

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun MyState(modifier: Modifier) {
    var number = remember { mutableStateOf(0) }

    Column(modifier = modifier) {
        Text(text = "Púlsame: ${number.value}", Modifier.clickable { number.value += 1 })
        Text(text = "Púlsame: ", Modifier.clickable { number.value += 1 })
        Text(text = "Púlsame:", Modifier.clickable { number.value += 1 })
        Text(text = "Púlsame: ${number.value}", Modifier.clickable { number.value += 1 })
        Text(text = "Púlsame:", Modifier.clickable { number.value += 1 })
    }


}