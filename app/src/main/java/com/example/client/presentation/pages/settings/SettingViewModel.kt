package com.example.client.presentation.pages.settings

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(): ViewModel(){
    private val _uiState = MutableStateFlow(SettingUiState())
    val uiState: StateFlow<SettingUiState> = _uiState.asStateFlow()

    init {
        _uiState.update { currentState ->
            currentState.copy(settingFunctions = SettingScreenData.functions)
        }
    }

    fun updateToggleState(index: Int){
        _uiState.update { currentState ->
            val newFunctions = currentState.settingFunctions.toMutableList().apply {
                this[index] = this[index].copy(toggleOn = !this[index].toggleOn)
            }
            currentState.copy(settingFunctions = newFunctions)
        }
    }
}