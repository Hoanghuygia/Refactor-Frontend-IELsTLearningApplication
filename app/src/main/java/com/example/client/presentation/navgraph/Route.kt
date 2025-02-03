package com.example.client.presentation.navgraph

sealed class Route(val route: String) {
    object LoginScreen: Route(route = "onLoginScreen")
}