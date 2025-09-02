package com.skyfallen.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyDivider(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text("The importance of discipline", fontWeight = FontWeight.Medium, fontSize = 20.sp)
        HorizontalDivider()
        Text(text = "Discipline is important because ......")

        Row(Modifier.padding(top = 20.dp)) {
            Text(text = "Left")
            VerticalDivider(Modifier.padding(start = 16.dp, end = 16.dp).height(80.dp))
            Text(text = "Right")
        }
    }
}