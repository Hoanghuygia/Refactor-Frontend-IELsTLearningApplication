package com.example.client.presentation.pages.reading.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.client.presentation.pages.reading.ReadingTabItem
import com.example.client.ui.theme.ClientTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ReadingTabs(tabs: List<ReadingTabItem>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        containerColor = Color.White,
        contentColor = Color.Black
    ) {
        tabs.forEachIndexed { index, tab ->
            Tab(
                text = { Text(text = tab.title) },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 411, heightDp = 892)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PreviewReadingTab() {
    ClientTheme {
        val tabs = listOf(ReadingTabItem.ReadingAcademic, ReadingTabItem.GeneralTrainingAcademic)
        val pagerState = rememberPagerState(
            pageCount = { tabs.size }
        )
        ReadingTabs(tabs = tabs, pagerState = pagerState)
    }
}