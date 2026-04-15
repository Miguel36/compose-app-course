package com.skyfallen.composecatalogapp.ui.concepts.navigation

import com.skyfallen.composecatalogapp.ui.concepts.navigation.model.SettingModel
import kotlinx.serialization.Serializable

@Serializable
object Login

@Serializable
object Home

@Serializable
data class Detail(val name: String, val isUser: Boolean)

@Serializable
data class Settings(val settingModel: SettingModel)