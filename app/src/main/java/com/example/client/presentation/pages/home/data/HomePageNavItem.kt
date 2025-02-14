package com.example.client.presentation.pages.home.data

import androidx.compose.ui.graphics.vector.ImageVector

data class HomePageNavItem(
    val title: String,
    val iconFilled: ImageVector,
    val iconOutlined: ImageVector,
    val route: String,
    val hasBadge: Boolean,
    val badgeNum: Int
)
