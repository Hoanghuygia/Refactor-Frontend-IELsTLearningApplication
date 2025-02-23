package com.example.client.presentation.pages.learning

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.client.presentation.common.CommonTopBar
import com.example.client.presentation.common.TopBarType
import com.example.client.presentation.pages.learning.components.LearningOption
import com.example.client.presentation.pages.learning.components.WordsPart
import com.example.client.ui.theme.ClientTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.client.presentation.pages.learning.components.CreateNewWordModal

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LearningScreen(navController: NavController, viewModel: LearningViewModel = hiltViewModel()) {
//    val uiState = viewModel.uiState.collectAsState().value
    val uiState by viewModel.uiState.collectAsState()
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            CommonTopBar(
                type = TopBarType.LearningTopBar.type,
                contentText = uiState.searchTextField,
                onSearchTextChanged = { newContent -> viewModel.updateSearchTextField(newContent) },
                onBackClick = { navController.popBackStack() },
                onSettingsClick = { showDialog = true })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            LearningOption(uiState.newest, viewModel = viewModel)
            WordsPart(words = uiState.words)
        }
    }
    if (showDialog) {
        CreateNewWordModal(
            word = uiState.wordTextField,
            wordType = uiState.wordTypeTextField,
            wordMeaning = uiState.wordMeaningTextField,
            viewModel = viewModel,
            onDismissRequest = { showDialog = false },
            onConfirmRequest = {
                showDialog = false
            }
        )
    }
}

@Preview(showBackground = true, widthDp = 411, heightDp = 892)
@Composable
fun PreviewLearningScreen(){
    ClientTheme {
        LearningScreen(navController = rememberNavController())
    }
}