package com.skyfallen.myfirstcomposeapp.components.navigation

import com.skyfallen.myfirstcomposeapp.components.navigation.model.SettingModel
import kotlinx.serialization.Serializable

@Serializable
object Login

@Serializable
object Home

@Serializable
data class Detail(val name: String, val isUser: Boolean)

@Serializable
data class Settings(val settingModel: SettingModel)