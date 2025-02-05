package com.example.client.presentation.pages.login

import androidx.lifecycle.ViewModel
import com.example.client.utils.TypeTextFieldX
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState

    init {
        // init something here in case needed
    }

    fun updateTextField(content: String, type: String) {
        _uiState.update { currentState ->
            when (type) {
                TypeTextFieldX.EMAIL.type -> currentState.copy(emailTextField = content)
                TypeTextFieldX.LAST_PASSWORD.type -> currentState.copy(passwordTextField = content)
                else -> currentState
            }
        }
    }

//    fun toggleCheckbox(){
//        _uiState.value = _uiState.value.copy(rememberMe = !re)
//    }

    fun toggleCheckbox() {
        _uiState.update { currentState ->
            currentState.copy(rememberMe = !currentState.rememberMe)
        }
    }

}