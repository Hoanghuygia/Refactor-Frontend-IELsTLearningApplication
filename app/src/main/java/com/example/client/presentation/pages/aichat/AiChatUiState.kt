package com.example.client.presentation.pages.aichat

import com.example.client.domain.model.Message

data class AiChatUiState(
    var messageTextField: String = "",
    var messages: List<Message> = emptyList<Message>(),
    var chatLabel: String = "",
    var user: String = ""
)