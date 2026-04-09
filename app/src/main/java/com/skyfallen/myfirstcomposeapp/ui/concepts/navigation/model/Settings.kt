package com.skyfallen.myfirstcomposeapp.ui.concepts.navigation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class SettingModel(val id: Int, val darkMode:Boolean): Parcelable
