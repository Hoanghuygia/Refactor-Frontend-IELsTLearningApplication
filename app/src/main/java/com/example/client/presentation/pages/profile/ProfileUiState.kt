package com.example.client.presentation.pages.profile

data class ProfileUiState(
    var emailTextField: String = "",
    var targetTextField: String = "",
    var editableMode: Boolean = true,
    var userStatus: Boolean = false,
    var optionsGender: List<String> = listOf("Male", "Female", "Other"),
    var selectedOptionText: String = "",
    var selectedDate: String = ""
)