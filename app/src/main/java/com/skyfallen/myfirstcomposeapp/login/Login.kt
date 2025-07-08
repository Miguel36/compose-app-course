package com.skyfallen.myfirstcomposeapp.login

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        "Hello $name",
        modifier = modifier
    )
}

/**
 * Con las Previews podemos testear y visualizar como esta quedando nuestro composable (Pieza de Lego),
 * además de añadir diversas propiedades para personalizar nuestra Preview
 */
@Preview(
    widthDp = 80,
    heightDp = 30,
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_4
)
@Composable
fun ExamplePreview() {
    // Solo se puede visualizar un composable que tenga parámetros, poniéndolo dentro de otro
    // Composable que no tenga parámetros.
    Example("One")
}

@Composable
fun Example(text: String) {
    Text("Skyfallen $text")
}

