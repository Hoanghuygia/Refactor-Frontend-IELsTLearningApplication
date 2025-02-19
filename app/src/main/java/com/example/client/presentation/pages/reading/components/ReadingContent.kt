package com.example.client.presentation.pages.reading.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.client.presentation.pages.reading.ReadingTabItem
import com.example.client.ui.theme.ClientTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ReadingTabContent(tabs: List<ReadingTabItem>, pagerState: PagerState) {
    HorizontalPager(
        state = pagerState,
        userScrollEnabled = true,
        modifier = Modifier.fillMaxSize() // need to specify because the pager need to know the area that used to dragging
    ) { page ->
        tabs[page].screen()
    }
}

@Preview(showBackground = true, widthDp = 411, heightDp = 892)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PreviewReadingTabContent() {
    ClientTheme {
        val tabs = listOf(ReadingTabItem.ReadingAcademic, ReadingTabItem.GeneralTrainingAcademic)
        val pagerState = rememberPagerState(
            pageCount = { tabs.size }
        )
        ReadingTabContent(tabs = tabs, pagerState = pagerState)
    }
}