package com.example.client.presentation.pages.reading

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.client.presentation.common.CommonTopBar
import com.example.client.presentation.pages.reading.components.ReadingTabContent
import com.example.client.presentation.pages.reading.components.ReadingTabs
import com.example.client.ui.theme.ClientTheme
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ReadingScreen(navController: NavController, viewModel: ReadingViewModel = hiltViewModel()) {
    val uiState = viewModel.uiState.collectAsState().value

    val tabs = listOf(ReadingTabItem.ReadingAcademic, ReadingTabItem.GeneralTrainingAcademic)
    val pagerState = rememberPagerState(initialPage = 0) { tabs.size }

    Scaffold(
        topBar = {
            CommonTopBar(
                type = "abc",
                contentText = uiState.searchTextField,
                onSearchTextChanged = { newContent -> viewModel.updateSearchTextField(newContent) },
                onBackClick = { navController.popBackStack() },
                onSettingsClick = {})
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            ReadingTabs(tabs = tabs, pagerState = pagerState)
            ReadingTabContent(tabs = tabs, pagerState = pagerState)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewReadingScreen() {
    ClientTheme {
        ReadingScreen(navController = rememberNavController())
    }
}
