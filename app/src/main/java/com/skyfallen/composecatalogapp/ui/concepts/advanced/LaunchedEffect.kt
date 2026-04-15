package com.skyfallen.composecatalogapp.ui.concepts.advanced

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun MyLaunchedEffect(modifier: Modifier = Modifier, onFinished: () -> Unit) {

    var timeLeft by remember { mutableIntStateOf(5) }

    LaunchedEffect(timeLeft) {
        if (timeLeft > -1) {
            delay(1000)
            timeLeft--
        }
        else {
            // Counter finished
            onFinished()
        }
    }

    LaunchedEffect(Unit) {
        /**
         * This launchedEffect with param Unit is only executed once
         */
    }

    Box(modifier = modifier.height(80.dp), contentAlignment = Alignment.Center) {
        Text(text = if (timeLeft > -1) timeLeft.toString() else "BOOOOM", fontSize = 30.sp)
    }
}