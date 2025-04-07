package com.example.client.presentation.pages.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.client.presentation.common.CommonTopBar
import com.example.client.presentation.common.TopBarType

@Composable
fun SettingsScreen(viewModel: SettingViewModel = hiltViewModel()) {
    val uiState = viewModel.uiState.collectAsState().value

    Scaffold(topBar = {
        CommonTopBar(type = TopBarType.SettingTopBar.type, contentText = "Setting")
    }) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {

        }

    }
}