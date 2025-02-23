package com.example.client.presentation.pages.learning

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.client.presentation.common.CommonTopBar
import com.example.client.presentation.common.TopBarType
import com.example.client.presentation.pages.learning.components.CreateNewWordModal
import com.example.client.presentation.pages.learning.components.LearningOption
import com.example.client.presentation.pages.learning.components.WordsPart
import com.example.client.ui.theme.ClientTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LearningScreen(navController: NavController, viewModel: LearningViewModel = hiltViewModel()) {
//    val uiState = viewModel.uiState.collectAsState().value
    val uiState by viewModel.uiState.collectAsState() // When compare about the performance, no big difference
    val context = LocalContext.current

    LaunchedEffect(uiState.words) {
        if (uiState.showDialog) {
            val lastWord = uiState.words.last()
            Toast.makeText(context, "Created: ${lastWord.word} successfully", Toast.LENGTH_SHORT).show()
            viewModel.updateShowDialog()
        }
    }

    Scaffold(
        topBar = {
            CommonTopBar(
                type = TopBarType.LearningTopBar.type,
                contentText = uiState.searchTextField,
                onSearchTextChanged = { newContent -> viewModel.updateSearchTextField(newContent) },
                onBackClick = { navController.popBackStack() },
                onSettingsClick = { viewModel.updateShowDialog() })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            LearningOption(uiState.newest, viewModel = viewModel)
            WordsPart(words = uiState.words, deleteOption = uiState.deleteOption, viewModel = viewModel)
        }
    }
    if (uiState.showDialog) {
        CreateNewWordModal(
            word = uiState.wordTextField,
            wordType = uiState.wordTypeTextField,
            wordMeaning = uiState.wordMeaningTextField,
            viewModel = viewModel,
            onDismissRequest = { viewModel.updateShowDialog() },
            onConfirmRequest = {
                viewModel.updateShowDialog()
            }
        )
    }
}

@Preview(showBackground = true, widthDp = 411, heightDp = 892)
@Composable
fun PreviewLearningScreen() {
    ClientTheme {
        LearningScreen(navController = rememberNavController())
    }
}