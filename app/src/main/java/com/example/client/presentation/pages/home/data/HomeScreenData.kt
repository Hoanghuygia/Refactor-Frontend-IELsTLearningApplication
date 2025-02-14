package com.example.client.presentation.pages.home.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Draw
import androidx.compose.material.icons.filled.Forum
import androidx.compose.material.icons.filled.Headphones
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ImportContacts
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Book
import androidx.compose.material.icons.outlined.Draw
import androidx.compose.material.icons.outlined.Forum
import androidx.compose.material.icons.outlined.Headphones
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ImportContacts
import androidx.compose.material.icons.outlined.Mic
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import com.example.client.presentation.navgraph.Route

object HomeScreenData {
    val subScreen = listOf(
        HomePageNavItem(
            title = "Home",
            iconFilled = Icons.Filled.Home,
            iconOutlined = Icons.Outlined.Home,
            Route.HomeScreen.route,
            hasBadge = false,
            badgeNum = 0
        ),
        HomePageNavItem(
            title = "My words",
            iconFilled = Icons.Filled.Book,
            iconOutlined = Icons.Outlined.Book,
            Route.HomeScreen.route,
            hasBadge = false,
            badgeNum = 0
        ),
        HomePageNavItem(
            title = "Notify",
            iconFilled = Icons.Filled.Notifications,
            iconOutlined = Icons.Outlined.Notifications,
            Route.HomeScreen.route,
            hasBadge = true,
            badgeNum = 10
        ),
        HomePageNavItem(
            title = "Account",
            iconFilled = Icons.Filled.Person,
            iconOutlined = Icons.Outlined.Person,
            Route.HomeScreen.route,
            hasBadge = false,
            badgeNum = 0
        ),
        HomePageNavItem(
            title = "Setting",
            iconFilled = Icons.Filled.Settings,
            iconOutlined = Icons.Outlined.Settings,
            Route.HomeScreen.route,
            hasBadge = false,
            badgeNum = 0
        )
    )
    val homePageItem = listOf(
        HomeScreenItem(
            title = "Read",
            iconFocus = Icons.Filled.ImportContacts,
            iconNormal = Icons.Outlined.ImportContacts,
            route = "onReadingScreen"
        ),
        HomeScreenItem(
            title = "Listen",
            iconFocus = Icons.Filled.Headphones,
            iconNormal = Icons.Outlined.Headphones,
            route = "onListeningScreen"
        ),
        HomeScreenItem(
            title = "Write",
            iconFocus = Icons.Filled.Draw,
            iconNormal = Icons.Outlined.Draw,
            route = "onWritingScreen"
        ),
        HomeScreenItem(
            title = "Speak",
            iconFocus = Icons.Filled.Mic,
            iconNormal = Icons.Outlined.Mic,
            route = "onSpeakingScreen"
        ),
        HomeScreenItem(
            title = "My words",
            iconFocus = Icons.Filled.Book,
            iconNormal = Icons.Outlined.Book,
            route = "onLibraryScreen"
        ),
        HomeScreenItem(
            title = "Chat with AI",
            iconFocus = Icons.Filled.Forum,
            iconNormal = Icons.Outlined.Forum,
            route = "onAIScreen"
        ),
    )
}