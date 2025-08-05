package com.skyfallen.myfirstcomposeapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun MyTextFieldParent(modifier: Modifier) {
    var user by remember { mutableStateOf("Miguel Angel") }
    var value by remember { mutableStateOf("") }

    Column(modifier = modifier) {
        MyTextField(user = user) { user = it }
        Spacer(Modifier.height(10.dp))

        MySecondTextField(value, { value = it })
        Spacer(Modifier.height(10.dp))

        MyTextFieldAdvanced(value) { value = it }
        Spacer(Modifier.height(10.dp))

        MyPasswordTextField(value) { value = it }
    }
}

@Composable
fun MyTextField(user: String, onUserChange: (String) -> Unit) {
    TextField(user, onValueChange = { onUserChange(it) }, readOnly = user.isEmpty())
}

@Composable
fun MySecondTextField(user: String, onUserChange: (String) -> Unit) {
    TextField(user, onValueChange = { onUserChange(it) }, placeholder = {
        Box(
            Modifier
                .size(20.dp)
                .background(
                    Color.Red
                )
        )
    }, label = { Text("Ingresa tu nombre") })
}

@Composable
fun MyTextFieldAdvanced(text: String, onValueChange: (String) -> Unit) {
    TextField(text, onValueChange = {
        if (it.contains("l")) {
            onValueChange(it.replace("l", ""))
        } else onValueChange(it)
    })
}

@Composable
fun MyPasswordTextField(value: String, onValueChange: (String) -> Unit) {
    var passwordHidden: Boolean by remember { mutableStateOf(true) }

    TextField(
        value = value, onValueChange = { onValueChange(it) },
        singleLine = true,
        label = { Text(text = "Input your password") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            Text(text = if (passwordHidden) "Show" else "Hide",
                Modifier
                    .clickable { passwordHidden = !passwordHidden }
                    .padding(end = 5.dp)
            )
        }

    )
}