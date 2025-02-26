package com.example.client.presentation.pages.learning

import com.example.client.domain.model.Word

data class LearningUiState(
    var searchTextField: String = "",
    var newest: Boolean = true,
    var words: List<Word> = listOf(),
    var wordTextField: String = "",
    var wordTypeTextField: String = "",
    var wordMeaningTextField: String = "",
    var showDialog: Boolean = false,
    var deleteOption: Boolean = false,
    var updateWordIndex: Int? = null,
    var deleteModal: Boolean = false,
)
