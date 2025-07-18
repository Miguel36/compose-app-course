package com.skyfallen.myfirstcomposeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.DarkGray
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

/**
 * Una barrera es como una linea imaginaria invisible (guía) que se sitúa justo después de el último
 * componente que haga parte de la barrera. No importa si los componentes que añadamos a la barrera cambian
 * de tamaño. La barrera siempre se va ubicar al final del último componete. Y en base a esa barrera
 * podemos organizar otras vistas que no están en la barrera para que se ubiquen antes de la
 * barrera o después. Este enfoque de usar barreras permite crear vistas más responsive o vistas que
 * no se rompan en distintos dispositivos ya que sin importar que el tamaño de un componente cambie.
 * Siempre se va a respeta la barrera
 */
@Composable
fun ConstraintBarrier(modifier: Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (redBox, yellowBox, cyanBox, darkGrayBox) = createRefs()
        val barrier = createEndBarrier(redBox, yellowBox)

        Box(Modifier
            .size(65.dp)
            .background(Red)
            .constrainAs(redBox) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            })

        Box(Modifier.size(100.dp).background(Color.Yellow).constrainAs(yellowBox) {
            top.linkTo(redBox.bottom, 40.dp)
            start.linkTo(parent.start, 16.dp)
        })

        Box(Modifier.size(65.dp).background(Cyan).constrainAs(cyanBox) {
            start.linkTo(barrier)
        })
        Box(Modifier.size(65.dp).background(DarkGray).constrainAs(darkGrayBox) {
            start.linkTo(barrier)
            top.linkTo(yellowBox.bottom)
        })
    }
}