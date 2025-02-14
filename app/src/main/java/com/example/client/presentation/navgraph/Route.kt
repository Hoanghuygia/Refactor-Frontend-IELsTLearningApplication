package com.example.client.presentation.navgraph

sealed class Route(val route: String) {
    object LoginScreen: Route(route = "onLoginScreen")
    object SignUpScreen: Route(route = "onSignUpScreen")
    object HomeScreen: Route(route = "onHomeScreen")
    object ProfileScreen: Route(route = "onProfileScreen")
    object ReadingScreen: Route(route = "onReadingScreen")
    object ListeningScreen: Route(route = "onListeningScreen")
    object WritingScreen: Route(route = "onWritingScreen")
    object SpeakingScreen: Route(route = "onSpeakingScreen")
    object LearningScreen: Route(route = "onLearningScreen")
    object AiChatScreen: Route(route = "onAiChatScreen")
    object NotificationScreen: Route(route = "onNotificationScreen")
    object SettingsScreen: Route(route = "onSettingsScreen")
}