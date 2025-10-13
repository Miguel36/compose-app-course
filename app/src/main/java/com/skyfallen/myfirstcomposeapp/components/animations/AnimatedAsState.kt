package com.skyfallen.myfirstcomposeapp.components.animations

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun FullAnimatedAsState(modifier: Modifier = Modifier) {
    var isSelected by remember { mutableStateOf(false) }
    val animatedColor by animateColorAsState(
        targetValue = if (isSelected) Color.Blue else Color.Red
    )
    val animatedSize by animateDpAsState(
        targetValue = if (isSelected) 220.dp else 120.dp
    )
    val animatedOffset by animateOffsetAsState(
        targetValue = if (isSelected) Offset(0f, 400f) else Offset(0f, 0f)
    )
    val animatedFloat by animateFloatAsState(
        targetValue = if (isSelected) 0.46f else 1f
    )

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
        Spacer(Modifier.height(30.dp))
        Button(onClick = { isSelected = !isSelected }) { Text("Presionar") }
        Spacer(Modifier.height(30.dp))

        Box(
            Modifier
                .offset(animatedOffset.x.dp, animatedOffset.y.dp)
                .size(animatedSize)
                .background(animatedColor.copy(animatedFloat))
        )
    }
}