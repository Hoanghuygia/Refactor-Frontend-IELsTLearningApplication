package com.example.client.presentation.pages.aichat

import com.example.client.domain.model.Message

object AiChatScreenData {
    val messages = listOf<Message>(
        Message(message = "Hello", entity = 0, timestamp = ""),
        Message(message = "How are you?", entity = 1, timestamp = ""),
        Message(message = "I'm good, thanks for asking!", entity = 0, timestamp = ""),
        Message(message = "What's your plan for today?", entity = 1, timestamp = ""),
        Message(message = "I have a few meetings and then some coding to do.", entity = 0, timestamp = ""),
        Message(message = "Sounds like a busy day!", entity = 1, timestamp = ""),
        Message(message = "What about you?", entity = 0, timestamp = ""),
        Message(message = "I have some errands to run and then a dinner with friends.", entity = 1, timestamp = ""),
        Message(message = "Nice! Enjoy your dinner.", entity = 0, timestamp = ""),
        Message(message = "Thank you! Have a productive day!", entity = 1, timestamp = ""),
        Message(message = "You too!", entity = 0, timestamp = "")
    )
}
