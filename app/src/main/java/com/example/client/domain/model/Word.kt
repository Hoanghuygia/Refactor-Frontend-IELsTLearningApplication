package com.example.client.domain.model

data class Word(
    val word: String,
    val type: String,
    val meaning: String,
    val createdAt: String = "",
    val updatedAt: String = ""
)
