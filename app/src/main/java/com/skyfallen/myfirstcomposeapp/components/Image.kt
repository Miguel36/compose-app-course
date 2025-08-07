package com.skyfallen.myfirstcomposeapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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