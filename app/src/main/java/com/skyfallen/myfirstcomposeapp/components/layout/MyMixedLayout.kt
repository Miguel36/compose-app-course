package com.skyfallen.myfirstcomposeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyComplexLayout(modifier: Modifier) {
    Column(modifier = modifier) {
        Box(Modifier
            .weight(1f)
            .fillMaxWidth()
            .background(Color.DarkGray), contentAlignment = Alignment.Center) {
            Row {
                Box(Modifier.weight(1f).height(120.dp).background(Color.Black), contentAlignment = Alignment.Center) {
                    Text(text = "How have you been?")
                }
                Box(Modifier.weight(1f).height(120.dp).background(Color.White), contentAlignment = Alignment.Center) {
                    Text(text = "How's it going?")
                }
            }
        }

        Box(Modifier
            .weight(1f)
            .fillMaxWidth()
            .background(Color.Black)) {
            Row(Modifier.align(Alignment.Center)) {
                Box(modifier = Modifier.weight(1f).height(120.dp).background(Color.White), contentAlignment = Alignment.Center) {
                    Text(text = "Hello")
                }
                Box(modifier = Modifier.weight(1f).height(120.dp).background(Color.DarkGray), contentAlignment = Alignment.Center) {
                    Text(text = "Hi!")
                }
            }
        }

        Box(Modifier
            .weight(1f)
            .fillMaxWidth(), contentAlignment = Alignment.Center) {
            Row {
                Box(modifier = Modifier.weight(1f).height(125.dp).background(Color.DarkGray), contentAlignment = Alignment.Center) {
                    Text(text = "Is everything ok?")
                }
                Box(modifier = Modifier.weight(1f).height(125.dp).background(Color.Black), contentAlignment = Alignment.Center) {
                    Text(text = "Are you good?")
                }
            }
        }
    }
}