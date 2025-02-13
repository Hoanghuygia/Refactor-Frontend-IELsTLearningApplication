package com.example.client.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val email: String,
    val fullName: String,
    val givenName: String,
    val familyName: String
)