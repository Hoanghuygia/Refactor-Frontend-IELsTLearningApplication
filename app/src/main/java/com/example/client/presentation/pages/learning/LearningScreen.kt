package com.example.client.presentation.pages.learning

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
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
import com.example.client.presentation.pages.learning.components.LearningOption
import com.example.client.presentation.pages.writing.WritingViewModel
import com.example.client.ui.theme.ClientTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LearningScreen(navController: NavController, viewModel: LearningViewModel = hiltViewModel()) {
    val uiState = viewModel.uiState.collectAsState().value

    Scaffold(
        topBar = {
            CommonTopBar(
                type = TopBarType.SearchTopBar.type,
                contentText = uiState.searchTextField,
                onSearchTextChanged = { newContent -> viewModel.updateSearchTextField(newContent) },
                onBackClick = { navController.popBackStack() },
                onSettingsClick = {})
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            LearningOption(uiState.newest, viewModel = viewModel)
        }
    }
}

@Preview(showBackground = true, widthDp = 411, heightDp = 892)
@Composable
fun PreviewLearningScreen(){
    ClientTheme {
        LearningScreen(navController = rememberNavController())
    }
}