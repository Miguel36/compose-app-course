package com.skyfallen.myfirstcomposeapp.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MyBadge(modifier: Modifier = Modifier) {
    Badge(modifier = modifier, contentColor = Color.Yellow, containerColor = Color.Black) {
        Text(text = "5")
    }
}

@Composable
fun MyBadgeBox(modifier: Modifier) {
    BadgedBox(modifier = modifier, badge = { MyBadge() }) {
        Icon(imageVector = Icons.Default.Notifications, contentDescription = "")
    }
}