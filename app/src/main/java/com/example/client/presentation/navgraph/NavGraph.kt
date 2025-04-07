package com.example.client.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.client.presentation.pages.aichat.AiChatScreen
import com.example.client.presentation.pages.home.HomeScreen
import com.example.client.presentation.pages.learning.LearningScreen
import com.example.client.presentation.pages.listening.ListeningScreen
import com.example.client.presentation.pages.login.LoginScreen
import com.example.client.presentation.pages.notification.NotificationScreen
import com.example.client.presentation.pages.profile.ProfileScreen
import com.example.client.presentation.pages.reading.ReadingScreen
import com.example.client.presentation.pages.settings.SettingsScreen
import com.example.client.presentation.pages.signup.SignUpScreen
import com.example.client.presentation.pages.speaking.SpeakingScreen
import com.example.client.presentation.pages.writing.WritingScreen

@Composable
fun NavGraph(startDestination: String) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        composable(route = Route.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Route.SignUpScreen.route) {
            SignUpScreen(navController = navController, modifier = Modifier)
        }
        composable(route = Route.HomeScreen.route){
            HomeScreen(navController = navController, modifier = Modifier)
        }
        composable(route = Route.ReadingScreen.route){
            ReadingScreen(navController = navController)
        }
        composable(route = Route.ListeningScreen.route){
            ListeningScreen(navController = navController)
        }
        composable(route = Route.WritingScreen.route){
            WritingScreen(navController = navController)
        }
        composable(route = Route.SpeakingScreen.route){
            SpeakingScreen(navController = navController)
        }
        composable(route = Route.LearningScreen.route){
            LearningScreen(navController = navController)
        }
        composable(route = Route.AiChatScreen.route){
            AiChatScreen(navController = navController)
        }
        composable(route = Route.NotificationScreen.route){
            NotificationScreen(navController = navController)
        }
        composable(route = Route.SettingsScreen.route){
            SettingsScreen()
        }
        composable(route = Route.ProfileScreen.route){
            ProfileScreen(navController = navController)
        }
    }
}