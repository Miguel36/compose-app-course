package com.skyfallen.myfirstcomposeapp.components.state

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun MyState(modifier: Modifier) {
    /**
     * "remember" Es suceptible a los cambios de orientación. Cuando se rota la pantalla del dispositivo
     * La vista se destruye y pierde los valores actuales del state. Si la app no cambia de orientación
     * podemos usar remembner sin ningún problema; sino, existen mejores alternativas
     */
    val number = remember { mutableStateOf(0) }

    Column(modifier = modifier) {
        Text(text = "Púlsame: ${number.value}", Modifier.clickable { number.value += 1 })
        Text(text = "Púlsame: ", Modifier.clickable { number.value += 1 })
        Text(text = "Púlsame:", Modifier.clickable { number.value += 1 })
        Text(text = "Púlsame: ${number.value}", Modifier.clickable { number.value += 1 })
        Text(text = "Púlsame:", Modifier.clickable { number.value += 1 })
    }
}

/**
 * Con esta alternativa podríamos rotar la pantalla del dispositivo y no se perdería la info del State,
 * debido a que ahora estamos usando es el "rememberSaveable" el cual almacena la info que ya existía
 * en el estado y cuando se rota la pantalla, si existe algún valor lo recupera. Útil si necesitamos
 * rotar la pantalla en nuestra App
 */
@Composable
fun MyStateTwo(modifier: Modifier) {
    /* Con la state property "by" podemos acceder directamente al valor sin necesidad de usar el .value,
     solo tendremos que importar el setValue y el getValue para poder acceder al valor o modificarlo */
    var number by rememberSaveable { mutableIntStateOf(0) }

    Column(modifier = modifier) {
        MyStateHosting1(number, onClick = { number += 1 })
        MyStateHosting2(number) { number += 1 }
    }
}

@Composable
fun MyStateHosting1(number: Int, onClick: () -> Unit) {
    Text(text = "Púlsame: $number", Modifier.clickable { onClick() })
}

@Composable
fun MyStateHosting2(number: Int, onClick: () -> Unit) {
    Text(text = "Púlsame: $number", Modifier.clickable { onClick() })
}

