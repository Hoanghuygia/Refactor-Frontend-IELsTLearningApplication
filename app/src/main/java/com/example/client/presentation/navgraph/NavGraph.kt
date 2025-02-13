package com.example.client.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.client.presentation.pages.login.LoginScreen
import com.example.client.presentation.pages.login.LoginViewModel
import com.example.client.presentation.pages.signup.SignUpScreen
import com.example.client.presentation.pages.signup.SignUpViewModel

@Composable
fun NavGraph(startDestination: String) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        composable(route = Route.LoginScreen.route) {
            val viewModel: LoginViewModel = hiltViewModel()
            LoginScreen(navController = navController, loginViewModel = viewModel)
        }
        composable(route = Route.SignUpScreen.route){
            val viewModel: SignUpViewModel = hiltViewModel()
            SignUpScreen(navController = navController, modifier = Modifier)
        }
    }
}