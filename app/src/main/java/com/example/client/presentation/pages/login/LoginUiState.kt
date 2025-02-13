package com.example.client.presentation.pages.login

data class LoginUiState(
    val emailTextField: String = "",
    val passwordTextField: String = "",
    val rememberMe: Boolean = false,
    val errorMessage: String? = null,
    val loading: Boolean = false,
    val token: String? = null,
    val message: String? = null
)
