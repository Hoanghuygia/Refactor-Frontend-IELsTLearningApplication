package com.example.client.presentation.pages.notification

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class NotificationViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(NotificationUiState())
    val uiState: StateFlow<NotificationUiState> = _uiState.asStateFlow()

    init {
        _uiState.update { currentState ->
            currentState.copy(notifications = NotificationScreenData.notifications)
        }
    }

    fun updateSeenState(index: Int) {
        _uiState.update { currentState ->
            val updatedNotifications = currentState.notifications.toMutableList().apply {
                this[index] = this[index].copy(seen = true)
            }
            currentState.copy(notifications = updatedNotifications)
        }
    }
}