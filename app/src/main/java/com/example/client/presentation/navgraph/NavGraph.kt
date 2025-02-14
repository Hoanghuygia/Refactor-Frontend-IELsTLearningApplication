package com.example.client.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.client.presentation.pages.home.HomeScreen
import com.example.client.presentation.pages.login.LoginScreen
import com.example.client.presentation.pages.signup.SignUpScreen

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
    }
}