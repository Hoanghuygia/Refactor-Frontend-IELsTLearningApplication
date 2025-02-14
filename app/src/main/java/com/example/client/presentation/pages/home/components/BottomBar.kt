package com.example.client.presentation.pages.home.components

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.client.presentation.pages.home.data.HomeScreenData.subScreen

@Composable
fun BottomBar(
    bottomNavState: Int,
    onNavItemClick: (Int) -> Unit
) {
    NavigationBar {
        subScreen.forEachIndexed { index, screen ->
            NavigationBarItem(
                selected = bottomNavState == index,
                onClick = {onNavItemClick(index)},
                icon = {
                    BadgedBox(badge = {
                        if (screen.hasBadge) Badge {}
                        if (screen.badgeNum != 0) {
                            Badge {
                                Text(text = screen.badgeNum.toString())
                            }
                        }
                    }) {
                        Icon(
                            imageVector = if (bottomNavState == index) {
                                screen.iconFilled
                            } else {
                                screen.iconOutlined
                            },
                            contentDescription = null
                        )
                    }
                },
                label = { Text(text = screen.title) }
            )
        }
    }
}