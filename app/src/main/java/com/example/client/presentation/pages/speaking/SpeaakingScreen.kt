package com.example.client.presentation.pages.speaking

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.client.presentation.common.CommonTopBar
import com.example.client.presentation.common.TabContent
import com.example.client.presentation.common.TabGeneral
import com.example.client.presentation.common.TabItem
import com.example.client.presentation.common.TopBarType
import com.example.client.presentation.pages.reading.ReadingViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SpeakingScreen(navController: NavController, viewModel: SpeakingViewModel = hiltViewModel()) {
    val uiState = viewModel.uiState.collectAsState().value

    val tabs = listOf(TabItem.SpeakingAcademic, TabItem.SpeakingGeneralTraining)
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