package com.skyfallen.myfirstcomposeapp.components.navigation

import kotlinx.serialization.Serializable

@Serializable
object Login

@Serializable
object Home

@Serializable
data class Detail(val name: String, val isUser: Boolean)