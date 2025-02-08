package com.example.client.presentation.pages.login

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.client.domain.usecase.localapp.AppUsecase
import com.example.client.utils.SupabaseClient.client
import com.example.client.utils.TypeTextFieldX
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.jan.supabase.compose.auth.composable.NativeSignInResult
import io.github.jan.supabase.exceptions.RestException
import io.github.jan.supabase.gotrue.gotrue
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val appUsecase: AppUsecase) : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState

//    init {
//        // init something here in case needed
//    }

    fun isUserLoggedIn(context: Context) {
        viewModelScope.launch {
            try {
                _uiState.update { currentState ->
                    currentState.copy(loading = true)
                }
                val token = appUsecase.readToken().first()

                if (token.isNullOrEmpty()) {
                    _uiState.update { currentState ->
                        currentState.copy(
                            message = "User is not logged in!!!!",
                            loading = false
                        )
                    }
                } else {
                    try {
                        client.gotrue.retrieveUser(token)
                        client.gotrue.refreshCurrentSession()
                        saveToken(context)
                        _uiState.update { currentState ->
                            currentState.copy(
                                message = "User is already logged in!!!",
                                loading = false
                            )
                        }
                    } catch (e: Exception) {
                        _uiState.update { currentState ->
                            currentState.copy(
                                errorMessage = e.message ?: "Error refreshing session",
                                loading = false
                            )
                        }
                    }
                }
            } catch (e: RestException) {
                _uiState.update { currentState ->
                    currentState.copy(
                        errorMessage = e.error,
                        loading = false
                    )
                }
            }
        }
    }

    fun checkGoogleLoginStatus(context: Context, result: NativeSignInResult) {
        viewModelScope.launch {
            when (result) {
                is NativeSignInResult.Success -> {
                    saveToken(context)
                    _uiState.update { currentState ->
                        currentState.copy(message = "Login successful")
                    }
                }
                is NativeSignInResult.Error -> {
                    _uiState.update { currentState ->
                        currentState.copy(errorMessage = result.message)
                    }
                }
                is NativeSignInResult.ClosedByUser -> {
                    _uiState.update { currentState ->
                        currentState.copy(message = "Login cancelled by user")
                    }
                }
                is NativeSignInResult.NetworkError -> {
                    _uiState.update { currentState ->
                        currentState.copy(errorMessage = "Network error. Please check your connection")
                    }
                }
            }
        }
    }

    private fun saveToken(context: Context) {
        viewModelScope.launch {
            val accessToken = client.gotrue.currentAccessTokenOrNull()
            appUsecase.saveToken(accessToken.toString())
        }
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