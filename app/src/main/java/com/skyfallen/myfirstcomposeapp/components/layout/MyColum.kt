package com.skyfallen.myfirstcomposeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun MyColum(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize().verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Text 1", modifier = Modifier.background(Color.Cyan))
        Text(text = "Text 2", modifier = Modifier.background(Color.Yellow))
        Text(text = "Text 3")
        Text(text = "Text 4", modifier = Modifier.background(Color.DarkGray))

        Text(text = "Text 1", modifier = Modifier.background(Color.Cyan))
        Text(text = "Text 2", modifier = Modifier.background(Color.Yellow))
        Text(text = "Text 3")
        Text(text = "Text 4", modifier = Modifier.background(Color.DarkGray))

        Text(text = "Text 1", modifier = Modifier.background(Color.Cyan))
        Text(text = "Text 2", modifier = Modifier.background(Color.Yellow))
        Text(text = "Text 3")
        Text(text = "Text 4", modifier = Modifier.background(Color.DarkGray))

        Text(text = "Text 1", modifier = Modifier.background(Color.Cyan))
        Text(text = "Text 2", modifier = Modifier.background(Color.Yellow))
        Text(text = "Text 3")
        Text(text = "Text 4", modifier = Modifier.background(Color.DarkGray))

        Text(text = "Text 1", modifier = Modifier.background(Color.Cyan))
        Text(text = "Text 2", modifier = Modifier.background(Color.Yellow))
        Text(text = "Text 3")
        Text(text = "Text 4", modifier = Modifier.background(Color.DarkGray))

        Text(text = "Text 1", modifier = Modifier.background(Color.Cyan))
        Text(text = "Text 2", modifier = Modifier.background(Color.Yellow))
        Text(text = "Text 3")
        Text(text = "Text 4", modifier = Modifier.background(Color.DarkGray))

        Text(text = "Text 1", modifier = Modifier.background(Color.Cyan))
        Text(text = "Text 2", modifier = Modifier.background(Color.Yellow))
        Text(text = "Text 3")
        Text(text = "Text 4", modifier = Modifier.background(Color.DarkGray))

        Text(text = "Text 1", modifier = Modifier.background(Color.Cyan))
        Text(text = "Text 2", modifier = Modifier.background(Color.Yellow))
        Text(text = "Text 3")
        Text(text = "Text 4", modifier = Modifier.background(Color.DarkGray))

        Text(text = "Text 1", modifier = Modifier.background(Color.Cyan))
        Text(text = "Text 2", modifier = Modifier.background(Color.Yellow))
        Text(text = "Text 3")
        Text(text = "Text 4", modifier = Modifier.background(Color.DarkGray))

        Text(text = "Text 1", modifier = Modifier.background(Color.Cyan))
        Text(text = "Text 2", modifier = Modifier.background(Color.Yellow))
        Text(text = "Text 3")
        Text(text = "Text 4", modifier = Modifier.background(Color.DarkGray))

        Text(text = "Text 1", modifier = Modifier.background(Color.Cyan))
        Text(text = "Text 2", modifier = Modifier.background(Color.Yellow))
        Text(text = "Text 3")
        Text(text = "Text 4", modifier = Modifier.background(Color.DarkGray))
    }
}
