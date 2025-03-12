package com.example.client.presentation.pages.profile

data class ProfileUiState(
    var birthday: String = "",
    var emailTextField: String = "",
    var targetTextField: String = "",
    var editableMode: Boolean = true,
    var userStatus: Boolean = false
)