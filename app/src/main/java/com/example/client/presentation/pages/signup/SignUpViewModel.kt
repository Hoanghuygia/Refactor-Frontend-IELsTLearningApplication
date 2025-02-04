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
                TextFieldType.USERNAME.type -> currentState.copy(username = text)
                TextFieldType.EMAIL.type -> currentState.copy(email = text)
                TextFieldType.PASSWORD.type -> currentState.copy(password = text)
                TextFieldType.CONFIRM_PASSWORD.type -> currentState.copy(confirmPassword = text)
                else -> currentState
            }
        }
    }
}

sealed class TextFieldType(
    val type: String
) {
    object USERNAME : TextFieldType(type = "USERNAME")
    object EMAIL : TextFieldType(type = "EMAIL")
    object PASSWORD : TextFieldType(type = "PASSWORD")
    object CONFIRM_PASSWORD : TextFieldType(type = "CONFIRM_PASSWORD")
}