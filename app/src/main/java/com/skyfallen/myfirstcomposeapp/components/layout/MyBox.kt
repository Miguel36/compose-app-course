package com.skyfallen.myfirstcomposeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * El Box no es un layout pero vendría siendo un contenedor que facilita la superposición de elementos
 * en Jetpack Compose, similar a un FrameLayout en el sistema de vistas tradicional de Android.
 */
@Preview
@Composable
fun MyBox() {
    Box(modifier = Modifier.fillMaxSize().background(Color.LightGray), contentAlignment = Alignment.Center) {
        Box(modifier = Modifier
            .size(200.dp)
            .background(Color.Red)
            .verticalScroll(rememberScrollState()), contentAlignment = Alignment.Center) {
            Text(text = "Hello World, Hello World")
        }
    }
}