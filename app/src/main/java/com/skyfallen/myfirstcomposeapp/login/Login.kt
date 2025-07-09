package com.skyfallen.myfirstcomposeapp.login

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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
@Preview
@Composable
fun ExamplePreview() {
    // Solo se puede visualizar un composable que tenga parámetros, poniéndolo dentro de otro
    // Composable que no tenga parámetros.
    Example("One")
}

@Composable
fun Example(text: String) {
    /**
     * Valor de Alto y Ancho deseado
     */
    //Text(text = "Skyfallen $text", modifier = Modifier.height(30.dp).width(90.dp))

    /**
     * Ancho y Alto con el mismo valor
     */
    //Text(text = "Skyfallen $text", modifier = Modifier.size(60.dp))

    /**
     * Ancho de toda la pantalla y alto con el valor deseado, fillMaxWidth() sería el equivalente
     * A lo que se conocía anteriormente como MATCH_PARENT
     */
    //Text(text = "Skyfallen $text", modifier = Modifier.fillMaxWidth().height(30.dp))

    /**
     * fillMaxSize() ocupa todo el ancho y todo el alto de la pantalla
     */
    Text(
        text = "Skyfallen $text", modifier = Modifier
            .fillMaxSize()
    )
}

