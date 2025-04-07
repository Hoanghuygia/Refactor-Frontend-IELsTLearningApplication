package com.example.client.presentation.pages.settings

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ToggleOff
import com.example.client.presentation.pages.settings.data.SettingFunctionObject

object SettingScreenData {
    val functions = listOf<SettingFunctionObject>(
        SettingFunctionObject(
            content = "Change Password",
            leadingIcon = Icons.Default.Key,
            trailingIcon = null
        ),
        SettingFunctionObject(
            content = "Notify",
            leadingIcon = Icons.Default.Notifications,
            trailingIcon = Icons.Default.ToggleOff
        ),
        SettingFunctionObject(
            content = "Dark Mode",
            leadingIcon = Icons.Default.LightMode,
            trailingIcon = Icons.Default.ToggleOff
        ),
    )
}