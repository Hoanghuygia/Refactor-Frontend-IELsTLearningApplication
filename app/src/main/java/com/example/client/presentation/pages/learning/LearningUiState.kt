package com.example.client.presentation.pages.learning

import com.example.client.domain.model.Word

data class LearningUiState(
    var searchTextField: String = "",
    var newest: Boolean = true,
    var words: List<Word> = listOf()
)
