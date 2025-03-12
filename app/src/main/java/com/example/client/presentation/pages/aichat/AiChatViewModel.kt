package com.example.client.presentation.pages.aichat

import androidx.lifecycle.ViewModel
import com.example.client.domain.model.Message
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.Calendar
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

    fun updateCurrentChat(newMessage: String, entity: Int) {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        _uiState.update { currentState ->
            currentState.copy(
                messages = currentState.messages + Message(
                    message = newMessage,
                    entity = entity,
                    timestamp = "$hour: $minute",
                )
            )
        }
    }

    fun clearEnterTextField() {
        _uiState.update { currentState ->
            currentState.copy(messageTextField = "")
        }
    }
}