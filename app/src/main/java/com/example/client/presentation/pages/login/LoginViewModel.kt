package com.example.client.presentation.pages.login

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState

    init {
        // init something here in case needed
    }

    fun updateTextField(content: String, type: String) {
        _uiState.update { currentState ->
            when (type) {
                "email" -> currentState.copy(emailTextField = content)
                "password" -> currentState.copy(passwordTextField = content)
                else -> currentState
            }
        }
    }

}