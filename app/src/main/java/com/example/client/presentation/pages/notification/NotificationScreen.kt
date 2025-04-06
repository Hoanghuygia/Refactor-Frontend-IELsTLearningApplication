package com.example.client.presentation.pages.notification

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.client.presentation.common.CommonTopBar
import com.example.client.presentation.common.TopBarType

@Composable
fun NotificationScreen(
    viewModel: NotificationViewModel = hiltViewModel(),
    navController: NavController
) {
    val uiState = viewModel.uiState.collectAsState().value

    Scaffold(
        topBar = {
            CommonTopBar(
                type = TopBarType.NotificationTopBar.type,
                contentText = "Notifications"
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

        }
    }
}