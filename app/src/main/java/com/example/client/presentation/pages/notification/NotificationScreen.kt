package com.example.client.presentation.pages.notification

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.client.presentation.common.CommonTopBar
import com.example.client.presentation.common.TopBarType
import com.example.client.presentation.pages.notification.coponents.IndividualNotification
import com.example.client.ui.theme.ClientTheme

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
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                itemsIndexed(uiState.notifications) { index, notification ->
                    IndividualNotification(
                        notification = notification,
                        index = index,
                        onUpdateSeenState = { idx -> viewModel.updateSeenState(index = idx) })
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 411, heightDp = 892)
@Composable
fun PreviewNotificationScreen() {
    ClientTheme {
        NotificationScreen(navController = rememberNavController())
    }
}