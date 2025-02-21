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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.client.presentation.common.CommonTopBar
import com.example.client.presentation.common.TabContent
import com.example.client.presentation.common.TabGeneral
import com.example.client.presentation.common.TabItem
import com.example.client.presentation.common.TopBarType
import com.example.client.ui.theme.ClientTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ReadingScreen(navController: NavController, viewModel: ReadingViewModel = hiltViewModel()) {
    val uiState = viewModel.uiState.collectAsState().value

    val tabs = listOf(TabItem.ReadingAcademic, TabItem.ReadingGeneralTraining)
    val pagerState = rememberPagerState(initialPage = 0) { tabs.size }

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
            TabGeneral(tabs = tabs, pagerState = pagerState)
            TabContent(tabs = tabs, pagerState = pagerState)
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
