package com.example.client.presentation.pages.settings

import com.example.client.presentation.pages.settings.data.SettingFunctionObject

data class SettingUiState(
    var settingFunctions: List<SettingFunctionObject> = emptyList<SettingFunctionObject>()
)
