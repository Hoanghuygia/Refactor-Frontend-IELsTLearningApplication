package com.example.client.presentation.navgraph

sealed class Route(val route: String) {
    object LoginScreen: Route(route = "onLoginScreen")
    object SignUpScreen: Route(route = "onSignUpScreen")
    object HomeScreen: Route(route = "onHomeScreen")
    object ProfileScreen: Route(route = "onProfileScreen")
}