package com.skyfallen.myfirstcomposeapp.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.skyfallen.myfirstcomposeapp.R

@Preview
@Composable
fun MyImage() {
    Image(
        painter = painterResource(R.drawable.profile_picture),
        contentDescription = "Avatar profile image",
        modifier = Modifier
            .height(300.dp)
            .width(170.dp)
            .clip(
                RoundedCornerShape(50)
            )
            .border(
                4.dp,
                shape = CircleShape,
                brush = Brush.linearGradient(colors = listOf(Color.Black, Color.Blue, Color.White))
            ),
        contentScale = ContentScale.FillBounds
    )
}

@Composable
fun MyNetworkImage(modifier: Modifier) {
    Column(modifier = modifier.fillMaxSize().fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AsyncImage(
            model = "https://musicstorecanarias.com/41867-medium_default/guitarra-electrica-esp-ltd-ec-256-qm-see-thru-black-cherry-sunburst.jpg",
            contentDescription = "Image from network",
            modifier = Modifier.width(320.dp).height(420.dp),
            contentScale = ContentScale.FillHeight,
            alignment = Alignment.Center,
            onError = { Log.i("image", "ha ocurrido un error ${it.result.throwable.message}") }
        )
    }
}

@Preview
@Composable
fun MyIcon() {
    Icon(
        painter = painterResource(R.drawable.ic_smile),
        contentDescription = null,
        Modifier.size(200.dp),
        tint = Color.Yellow
    )
}