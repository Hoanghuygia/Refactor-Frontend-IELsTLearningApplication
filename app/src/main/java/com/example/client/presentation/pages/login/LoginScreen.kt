package com.example.client.presentation.pages.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.client.presentation.pages.login.components.BottomLogin
import com.example.client.presentation.pages.login.components.HeaderWelcome
import com.example.client.ui.theme.ClientTheme

@Composable
fun LoginScreen(navController: NavController, loginViewModel: LoginViewModel = hiltViewModel()) {
    val uiState = loginViewModel.uiState.collectAsState().value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF002147))
    ) {
        HeaderWelcome()
        BottomLogin(uiState = uiState, loginViewModel = loginViewModel)
    }
}

@Preview(showBackground = true, widthDp = 411, heightDp = 892) // For Samsung Galaxy A23 5G
@Composable
fun PreviewBottomLogin() {
    ClientTheme {
        val navController = rememberNavController()

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF002147))
        ) {
            LoginScreen(navController = navController)
        }
    }
}
