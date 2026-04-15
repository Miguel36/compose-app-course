package com.skyfallen.composecatalogapp.ui.concepts.advanced

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun MyInteractionSource(modifier: Modifier = Modifier) {
    /**
     * InteractionSource allows to know the component state (Pressed, dragged, Hovered, etc...)
     */
    val interaction = remember { MutableInteractionSource() }
    val isPressed by interaction.collectIsPressedAsState()

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier
                .size(150.dp)
                .shadow(if (isPressed) 10.dp else 2.dp)
                .background(if (isPressed) Color.Red else Color.Yellow)
                .clickable(interactionSource = interaction, indication = LocalIndication.current) {

                },
            contentAlignment = Alignment.Center
        ) {
            Text(text = if (isPressed) "Pulsado" else "Sin pulsar")
        }
        Spacer(Modifier.height(20.dp))
        Button(onClick = {}, interactionSource = interaction) { Text("Shared Interaction") }
    }

}