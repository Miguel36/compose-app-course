package com.skyfallen.myfirstcomposeapp.components.model

import androidx.compose.ui.graphics.vector.ImageVector

data class MenuItem(
    val icon: ImageVector,
    val text: String,
    val notificationsNumber: Int
)
