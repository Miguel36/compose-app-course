package com.skyfallen.myfirstcomposeapp.components.advanced

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyDerivedStateOf(modifier: Modifier = Modifier) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    /**
     * El derivaded state of nos ayuda a que los composables no se estén recomponiendo cada momento
     * cuando no es necesario, solo le asignamos la condición que requerimos para nuestra validación
     * y con esto, solo se actualizará el composable cuando se cumpla la misma. De lo contrario la vista
     * se estaría recomponiendo cada vez que se escribe el email o password lo cual no es óptimo.
     */
    val isLoginValid by remember(email, password) {
        derivedStateOf {
            email.contains("@") && password.length > 4
        }
    }

    Column(
        modifier = modifier.background(Color.White).border(2.dp, Color.Red).padding(12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(value = email, onValueChange = { email = it })
        Spacer(Modifier.height(6.dp))

        TextField(value = password, onValueChange = { password = it })
        Spacer(Modifier.height(8.dp))

        Button(onClick = {}, enabled = isLoginValid) {
            Text("Login")
        }
    }
}