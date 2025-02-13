package com.example.client.presentation.pages.signup

import androidx.lifecycle.ViewModel
import com.example.client.utils.TypeTextFieldX
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
                TypeTextFieldX.USERNAME.type -> currentState.copy(username = text)
                TypeTextFieldX.EMAIL.type -> currentState.copy(email = text)
                TypeTextFieldX.PASSWORD.type -> currentState.copy(password = text)
                TypeTextFieldX.LAST_PASSWORD.type -> currentState.copy(confirmPassword = text)
                else -> currentState
            }
        }
    }
}
