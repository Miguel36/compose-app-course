package com.skyfallen.myfirstcomposeapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp

@Composable
fun MyText(modifier: Modifier) {
    Column(modifier = modifier) {
        Text("Pepito")
        Text("Pepe rojo", color = Color.Red)
        Text(text = "FontSize", fontSize = 25.sp)
        Text(text = "FontStyle", fontStyle = FontStyle.Italic)
        Text(
            text = "FontWeight",
            fontWeight = FontWeight.SemiBold,
            fontSize = 25.sp,
            fontStyle = FontStyle.Italic
        )
        Text(text = "LetterSpacing", letterSpacing = 8.sp)
        Text(text = "Text decoration type link",  textDecoration = TextDecoration.Underline, color = Color.Blue, modifier = Modifier.clickable {  })
        Text(text = "TextDecoration Combined", textDecoration = TextDecoration.Underline + TextDecoration.LineThrough)
        Text(text = "Align, Align, Align, Align Align Align Align Align Align Align", Modifier.fillMaxWidth(), textAlign = TextAlign.Center, maxLines = 1, overflow = TextOverflow.Ellipsis)
    }

}