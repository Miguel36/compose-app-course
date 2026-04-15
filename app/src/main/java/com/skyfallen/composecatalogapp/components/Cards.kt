package com.skyfallen.composecatalogapp.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun MyCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth().padding(16.dp),
        shape = MaterialTheme.shapes.extraLarge,
        border = BorderStroke(width = 3.dp, brush = Brush.linearGradient(colors = listOf(Color.Black, Color.Red))),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.Red,
            disabledContainerColor = Color.LightGray,
            disabledContentColor = Color.DarkGray
        ),
        enabled = true,
        onClick = {}
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .padding(12.dp)
                    .size(75.dp)
                    .clip(CircleShape)
                    .background(Color.Red)
            )
            Column {
                Text(text = "Skyfallen Dev", fontSize = 28.sp, fontWeight = FontWeight.SemiBold, color = Color.Black)
                Text(text = "Hi, I'm Miguel and this is my portal", fontSize = 20.sp, fontStyle = FontStyle.Italic)
            }
        }
    }
}

@Preview
@Composable
fun MyElevatedCard(modifier: Modifier = Modifier) {
    ElevatedCard(
        modifier = modifier.fillMaxWidth().padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.Red,
            disabledContainerColor = Color.LightGray,
            disabledContentColor = Color.DarkGray
        ),
        enabled = true,
        onClick = {}
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .padding(12.dp)
                    .size(75.dp)
                    .clip(CircleShape)
                    .background(Color.Red)
            )
            Column {
                Text(text = "Skyfallen Dev", fontSize = 28.sp, fontWeight = FontWeight.SemiBold, color = Color.Black)
                Text(text = "Hi, I'm Miguel and this is my portal", fontSize = 20.sp, fontStyle = FontStyle.Italic)
            }
        }
    }
}

@Preview
@Composable
fun MyOutlinedCard(modifier: Modifier = Modifier) {
    OutlinedCard (
        modifier = modifier.fillMaxWidth().padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.Red,
            disabledContainerColor = Color.LightGray,
            disabledContentColor = Color.DarkGray
        ),
        enabled = true,
        onClick = {}
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .padding(12.dp)
                    .size(75.dp)
                    .clip(CircleShape)
                    .background(Color.Red)
            )
            Column {
                Text(text = "Skyfallen Dev", fontSize = 28.sp, fontWeight = FontWeight.SemiBold, color = Color.Black)
                Text(text = "Hi, I'm Miguel and this is my portal", fontSize = 20.sp, fontStyle = FontStyle.Italic)
            }
        }
    }
}