package com.example.client.utils

sealed class TypeTextFieldX(
    val type: String
) {
    object USERNAME : TypeTextFieldX(type = "USERNAME")
    object EMAIL : TypeTextFieldX(type = "EMAIL")
    object PASSWORD : TypeTextFieldX(type = "PASSWORD")
    object LAST_PASSWORD : TypeTextFieldX(type = "LAST_PASSWORD")
}
