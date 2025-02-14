package com.example.client.presentation.pages.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.client.presentation.pages.home.components.BottomBar
import com.example.client.ui.theme.ClientTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.client.R
import com.example.client.domain.model.User
import com.example.client.presentation.navgraph.Route
import com.example.client.presentation.pages.home.components.ContentHolder
import com.example.client.presentation.pages.home.components.ProfileHolder
import com.example.client.presentation.pages.home.data.HomeScreenData
import com.example.client.presentation.pages.learning.LearningScreen
import com.example.client.presentation.pages.notification.NotificationScreen
import com.example.client.presentation.pages.profile.ProfileScreen
import com.example.client.presentation.pages.settings.SettingsScreen

@Composable
fun HomeScreen(navController: NavController, modifier: Modifier) {
    var bottomNavState by rememberSaveable { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            BottomBar(
                bottomNavState = bottomNavState,
                onNavItemClick = { index -> bottomNavState = index })
        }
    ) { innerPadding ->
        Box(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()) {
            when (bottomNavState) {
                0 -> {
                    Column(
                        modifier = modifier
                            .fillMaxSize()
                            .background(Color.White)
                            .padding(start = 32.dp, end = 32.dp, top = 32.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        ProfileHolder(currentUser = User(
                            email = "Test@gmail.com",
                            fullName = "NPDQ",
                            givenName = "Q",
                            familyName = "N",
                            avatar = R.drawable.avatar
                        ),
                            modifier = Modifier.weight(1f),
                            onEvent = { navController.navigate(Route.ProfileScreen.route) })

                        val homePageItemLength = HomeScreenData.homePageItem.size
                        if (homePageItemLength % 2 == 0) {
                            for (i in 0 until homePageItemLength - 1 step 2) {
                                val first = HomeScreenData.homePageItem[i]
                                val second = HomeScreenData.homePageItem[i + 1]
                                ContentHolder(
                                    first,
                                    second,
                                    modifier = Modifier.weight(1f),
                                    navController = navController
                                )
                            }
                        }
                    }
                }
                1 -> {
                    LearningScreen()
                }
                2 -> {
                    NotificationScreen()
                }
                3 -> {
                    ProfileScreen()
                }
                4 -> {
                    SettingsScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 411, heightDp = 892)
@Composable
fun PreviewHomeScreen() {
    ClientTheme {
        val navController = rememberNavController()
        HomeScreen(navController = navController, modifier = Modifier)
    }
}
