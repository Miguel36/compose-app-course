package com.skyfallen.myfirstcomposeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun MyBasicConstraintLayout(modifier: Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (boxRed, boxGray, boxGreen, boxMagenta, boxYellow) = createRefs()

        Box(Modifier.size(135.dp).background(Color.Red).constrainAs(boxRed) {
            top.linkTo(boxYellow.bottom)
            start.linkTo(boxYellow.end)
        })
        Box(Modifier.size(135.dp).background(Color.Gray).constrainAs(boxGray) {
            top.linkTo(boxYellow.bottom)
            end.linkTo(boxYellow.start)
        })
        Box(Modifier.size(135.dp).background(Color.Green).constrainAs(boxGreen) {
            bottom.linkTo(boxYellow.top)
            start.linkTo(boxYellow.end)
        })
        Box(Modifier.size(135.dp).background(Color.Magenta).constrainAs(boxMagenta) {
            bottom.linkTo(boxYellow.top)
            end.linkTo(boxYellow.start)
        })
        Box(Modifier.size(135.dp).background(Color.Yellow).constrainAs(boxYellow) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
        })

    }
}

/**
 * Un GuideLine permite crear una guía (Espacio) invisible superior, inferior, al inicio o al final de la
 * pantalla, deacuerdo al porcentaje que le indiquemos. En este caso tiene un 10% tanto en la parte
 * superior, como al inicio (izquierda) de la pantalla. Esto permite que las vistas que añadamos se
 * pueadn alinear después de esa guía y sin importar el tamaño del dispositivo, tomaría el 10 % lo que haría
 * que la construcción de los diseños sea más responsive.
 */
@Composable
fun ConstraintExampleGuide(modifier: Modifier) {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val boxRed = createRef()
        val guideStart = createGuidelineFromStart(0.1f)
        val guideTop = createGuidelineFromTop(0.1f)

        Box(Modifier.size(80.dp).background(Red).constrainAs(boxRed) {
            start.linkTo(guideStart)
            top.linkTo(guideTop)
        })
    }
}