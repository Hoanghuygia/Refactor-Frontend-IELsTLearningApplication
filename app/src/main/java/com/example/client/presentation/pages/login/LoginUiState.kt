package com.example.client.presentation.pages.login

data class LoginUiState(
    var emailTextField: String = "",
    var passwordTextField: String = "",
    var rememberMe: Boolean = false,
)
