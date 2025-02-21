package com.example.client.presentation.common

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.client.presentation.common.TabItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabContent(tabs: List<TabItem>, pagerState: PagerState) {
    HorizontalPager(
        state = pagerState,
        userScrollEnabled = true,
        modifier = Modifier.fillMaxSize() // need to specify because the pager need to know the area that used to dragging
    ) { page ->
        tabs[page].screen()
    }
}