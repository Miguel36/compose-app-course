package com.skyfallen.myfirstcomposeapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.skyfallen.myfirstcomposeapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(onMenuSelected: () -> Unit) {
    TopAppBar(
        title = { Text(text = "My App") },
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Icon from TopAppBar",
                modifier = Modifier
                    .clickable { onMenuSelected() }
                    .padding(end = 8.dp, start = 4.dp),
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