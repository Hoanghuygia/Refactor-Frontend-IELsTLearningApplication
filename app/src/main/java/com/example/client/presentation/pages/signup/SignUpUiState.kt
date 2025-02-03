package com.example.client.presentation.pages.signup

data class SignUpUiState(
    var username: String = "",
    var email: String = "",
    var password: String = "",
    var confirmPassword: String = ""
)