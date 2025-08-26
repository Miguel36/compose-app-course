package com.skyfallen.myfirstcomposeapp.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.skyfallen.myfirstcomposeapp.R

@Composable
fun MyButtons(modifier: Modifier) {
    Column(modifier = modifier) {
        // Alto énfasis
        Button(
            onClick = { Log.i("OnClick Sky", "OnClick Button") },
            Modifier
                .height(40.dp)
                .width(120.dp),
            enabled = true,
            shape = RoundedCornerShape(15),
            border = BorderStroke(2.dp, Color.Red),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black,
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.DarkGray
            )
        ) {
            Text(text = "Púlsame", color = Color.Blue)
        }

        // Medio énfasis
        OutlinedButton(
            onClick = {},
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.White,
                contentColor = Color.Cyan
            )
        ) {
            Text("Outlined", color = Color.Black)
        }

        // Bajo énfasis
        TextButton(onClick = {}) { Text(text = "TextButton") }

        // Lo unico relevante, es que es un botón con más elevación por defecto
        ElevatedButton(onClick = {}) { Text("Elevated Button") }

        // Medio énfasis, la unica diferencia respecto al button normal es que su color es mas claro
        FilledTonalButton(onClick = {}) { Text("FilledTonalButton") }
    }
}

/**
 * This component (Floating Action Button) can be added into Scaffold for customizing our main View
 */
@Composable
fun MyFab() {
    FloatingActionButton(
        onClick = {},
        shape = CircleShape,
        contentColor = Color.Black,
        containerColor = Color.Red,
        elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 4.dp)
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_add),
            contentDescription = "",
            modifier = Modifier.size(30.dp)
        )
    }
}