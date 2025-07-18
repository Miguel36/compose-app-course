package com.skyfallen.myfirstcomposeapp.components.exercises

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ConstraintLayoutExercise(modifier: Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (cyanBox, blackBox, darkGrayBox, magentaBox, greenBox, yellowBox, lightGrayBox, redBox, blueBox) = createRefs()

        Box(Modifier.size(75.dp).background(Color.Yellow).constrainAs(yellowBox) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
        Box(Modifier.size(75.dp).background(Color.Magenta).constrainAs(magentaBox) {
            bottom.linkTo(yellowBox.top)
            end.linkTo(yellowBox.start)
        })
        Box(Modifier.size(75.dp).background(Color.Green).constrainAs(greenBox) {
            bottom.linkTo(yellowBox.top)
            start.linkTo(yellowBox.end)
        })

        Box(Modifier.size(175.dp).background(Color.Cyan).constrainAs(cyanBox) {
            bottom.linkTo(magentaBox.top)
            end.linkTo(magentaBox.end)
        })
        Box(Modifier.size(175.dp).background(Color.DarkGray).constrainAs(darkGrayBox) {
            bottom.linkTo(greenBox.top)
            start.linkTo(greenBox.start)
        })
        Box(Modifier.size(75.dp).background(Color.Black).constrainAs(blackBox) {
            start.linkTo(cyanBox.end)
            end.linkTo(darkGrayBox.start)
            top.linkTo(cyanBox.top)
            bottom.linkTo(cyanBox.bottom)
        })

        Box(Modifier.size(175.dp).background(Color.Blue).constrainAs(blueBox) {
            top.linkTo(yellowBox.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
        Box(Modifier.size(75.dp).background(Color.LightGray).constrainAs(lightGrayBox) {
            top.linkTo(yellowBox.bottom)
            end.linkTo(yellowBox.start)
        })
        Box(Modifier.size(75.dp).background(Color.Red).constrainAs(redBox) {
            top.linkTo(yellowBox.bottom)
            start.linkTo(yellowBox.end)
        })

    }
}