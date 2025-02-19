package com.example.client.presentation.pages.reading

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.client.presentation.common.CommonTopBar
import com.example.client.presentation.pages.reading.components.ReadingTabContent
import com.example.client.presentation.pages.reading.components.ReadingTabs
import com.example.client.ui.theme.ClientTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ReadingScreen() {
    val tabs = listOf(ReadingTabItem.ReadingAcademic, ReadingTabItem.GeneralTrainingAcademic)
//    val pagerState = rememberPagerState(pageCount = { tabs.size })
    val pagerState = rememberPagerState(initialPage = 0) { tabs.size }

    Scaffold(
        topBar = {
            CommonTopBar(
                type = "abc",
                searchText = "Search",
                onSearchTextChanged = {},
                onBackClick = {},
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
        ReadingScreen()
    }
}
