package com.example.client.utils

object UtilFunctions {
    fun truncateToWords(text: String, wordCount: Int): String {
        return text.split(" ").take(wordCount).joinToString(" ") + "..."
    }
}