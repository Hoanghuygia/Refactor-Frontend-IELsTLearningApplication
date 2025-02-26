package com.example.client.presentation.pages.aichat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.client.presentation.common.CommonTopBar
import com.example.client.presentation.common.TopBarType
import com.example.client.presentation.pages.aichat.components.Messages
import com.example.client.presentation.pages.learning.components.SendingBar
import com.example.client.ui.theme.ClientTheme

@Composable
fun AiChatScreen(viewModel: AiChatViewModel = hiltViewModel(), navController: NavController) {
    val uiState = viewModel.uiState.collectAsState().value

    val navigationBarHeight = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()

    Scaffold(
        topBar = {
            CommonTopBar(
                type = TopBarType.AIChatTopBar.type,
                contentText = TopBarType.AIChatTopBar.textContent.toString(),
                onSearchTextChanged = { },
                onBackClick = { navController.popBackStack() },
                onSettingsClick = { }
            )
        },
        bottomBar = { SendingBar(uiState = uiState, viewModel = viewModel, modifier = Modifier) }
    ) { innerPadding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)) {
            Messages(messages = uiState.messages, modifier = Modifier.weight(1f))
        }
    }
}

@Preview(showBackground = true, widthDp = 411, heightDp = 892)
@Composable
fun PreviewAiChatScreen(){
    ClientTheme {
        AiChatScreen(navController = rememberNavController())
    }
}
