package com.skyfallen.myfirstcomposeapp.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.skyfallen.myfirstcomposeapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar() {
    TopAppBar(
        title = { Text(text = "My App") },
        navigationIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_smile),
                contentDescription = "Icon from TopAppBar"
            )
        },
        actions = {
            Icon(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "Icon from TopAppBar"
            )
            Icon(
                painter = painterResource(R.drawable.ic_smile),
                contentDescription = "Icon from TopAppBar"
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Yellow,
            titleContentColor = Color.Black,
            navigationIconContentColor = Color.Red,
            actionIconContentColor = Color.Blue
        )
    )
}