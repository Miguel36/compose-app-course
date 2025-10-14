package com.skyfallen.myfirstcomposeapp.components.animations

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun MyAnimatedContent(modifier: Modifier = Modifier) {
    var value by remember { mutableIntStateOf(0) }

    Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(Modifier.height(24.dp))
        Button(onClick = { value++ }) { Text("Plus") }
        Spacer(Modifier.height(32.dp))

        /**
         * @AnimatedContent animate the contain (composables) each time that targetState changes
         */
        AnimatedContent(targetState = value) { result ->
            when (result) {
                0 -> Text(text = "The value is: $result")
                1 -> Box(Modifier.size(50.dp).background(Color.Red))
                2 -> Button(onClick = {}) { Text("Heeeeeeey") }
                3 ->  Box(Modifier.size(150.dp).background(Color.Blue.copy(0.55f)))
                else -> Text(text = "The value is: $result")
            }
        }

    }
}