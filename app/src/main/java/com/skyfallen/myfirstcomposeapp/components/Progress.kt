package com.skyfallen.myfirstcomposeapp.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.skyfallen.myfirstcomposeapp.R

@Composable
fun MyProgress(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            Modifier.size(130.dp),
            color = Color.Red,
            strokeWidth = 7.dp,
            trackColor = Color.Yellow,
            strokeCap = StrokeCap.Round
        )
        Spacer(Modifier.height(24.dp))
        LinearProgressIndicator()
    }
}

@Composable
fun MyProgressAdvance(modifier: Modifier) {
    var progress by remember { mutableFloatStateOf(0.5f) }
    val  animatedProgress by animateFloatAsState(targetValue = progress)
    var isLoading by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                progress = { animatedProgress },
                Modifier.size(130.dp),
                color = Color.Red,
                strokeWidth = 8.dp,
                trackColor = Color.LightGray,
                strokeCap = StrokeCap.Square,
                gapSize = 3.dp
            )
        }

        Spacer(Modifier.height(24.dp))

        LinearProgressIndicator(progress = { animatedProgress }, trackColor = Color.DarkGray)

        Row(Modifier.padding(24.dp)) {
            FilledTonalButton(onClick = { if (progress >= 0.1f) progress -= 0.1f }) {
                Text(text = "-")
            }
            Spacer(Modifier.width(24.dp))
            Button(onClick = { if (progress < 1.0f) progress += 0.1f }) {
                Text(text = "+")
            }
        }
        Button(onClick = {isLoading = !isLoading}) {
            Text(text = "Show/Hide loading")
        }
    }
}

@Composable
fun MyLottieAnimationProgress(modifier: Modifier) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.hourglass_loading))

    Column(modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        LottieAnimation(composition = composition, iterations = LottieConstants.IterateForever)
    }
}