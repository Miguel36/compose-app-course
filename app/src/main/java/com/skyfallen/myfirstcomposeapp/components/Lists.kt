package com.skyfallen.myfirstcomposeapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyBasicList(modifier: Modifier = Modifier) {

    val nameList = listOf("Miguel", "Jose", "Daniela", "Pepe", "Matias", "Jesús")

    LazyColumn(modifier = modifier.padding(vertical = 12.dp)) {
        items(nameList) {
            Text(it, modifier = Modifier.background(Color.Yellow))
        }
    }
}