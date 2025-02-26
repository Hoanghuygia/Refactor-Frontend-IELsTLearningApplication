package com.example.client.presentation.pages.aichat

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class AiChatViewModel @Inject constructor(): ViewModel() {
    private val _uiState = MutableStateFlow(AiChatUiState())
    val uiState: StateFlow<AiChatUiState> = _uiState.asStateFlow()

    init{
        _uiState.value.messages = AiChatScreenData.messages
    }

    fun updateMessageTextField(newContent: String) {
        _uiState.update { currentState ->
            currentState.copy(messageTextField = newContent)
        }
    }
}