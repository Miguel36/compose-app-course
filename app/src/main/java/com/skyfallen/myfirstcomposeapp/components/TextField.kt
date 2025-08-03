package com.skyfallen.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyTextField(modifier: Modifier) {
    Column(modifier = modifier) {
        var text by remember { mutableStateOf("") }
        TextField(text, onValueChange = {newValue -> text = newValue})
        Spacer(Modifier.height(10.dp))
        // This is the same as the example above
        TextField(text, onValueChange = {text = it})
    }
}