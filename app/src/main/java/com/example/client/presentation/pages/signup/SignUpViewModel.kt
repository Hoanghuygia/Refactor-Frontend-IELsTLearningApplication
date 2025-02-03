package com.example.client.presentation.pages.signup

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(): ViewModel(){
    private val _uiState = MutableStateFlow(SignUpUiState())
    val uiState: StateFlow<SignUpUiState> = _uiState

    fun updateTextField(text: String, type: String){
        _uiState.update { currentState ->
            when (type) {
                "username" -> currentState.copy(username = text)
                "email" -> currentState.copy(email = text)
                "password" -> currentState.copy(password = text)
                "confirmPassword" -> currentState.copy(confirmPassword = text)
                else -> currentState
            }
        }
    }
}