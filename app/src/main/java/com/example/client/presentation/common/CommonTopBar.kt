package com.example.client.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.EditNote
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.client.presentation.pages.aichat.components.ChatsMenu
import com.example.client.ui.theme.ClientTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonTopBar(
    type: String?,
    contentText: String,
    onSearchTextChanged: (String) -> Unit = {},
    onBackClick: () -> Unit = {},
    onSettingsClick: () -> Unit = {},
    onChangeProfileClick: () -> Unit = {}
) {
    TopAppBar(
        modifier = Modifier.then(
            if (type == TopBarType.ProfileTopBar.type) Modifier.height(70.dp) else Modifier
        ),
        navigationIcon = {
//            if (type != TopBarType.ProfileTopBar.type) {
            IconButton(onClick = onBackClick) {
                Icon(
                    Icons.Default.ArrowBackIosNew,
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.tertiary
                )
            }
//            }
        },
        title = {
            if (type == TopBarType.SearchTopBar.type) {
                BasicTextField(
                    value = contentText,
                    onValueChange = onSearchTextChanged,
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(42.dp)
                        .clip(RoundedCornerShape(50))
                        .background(Color.LightGray.copy(alpha = 0.5f))
                        .padding(horizontal = 16.dp, vertical = 10.dp),
                    textStyle = TextStyle(
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.tertiary,
                        lineHeight = 18.sp
                    ),
                    decorationBox = { innerTextField ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Icon(
                                Icons.Default.Search,
                                contentDescription = "Search Icon",
                                tint = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.7f)
                            )
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(start = 6.dp)
                            ) {
                                if (contentText.isEmpty()) {
                                    Text(
                                        text = "Search...",
                                        color = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.7f),
                                        fontSize = 14.sp,
                                        lineHeight = 18.sp,
                                        modifier = Modifier.padding(bottom = 2.dp)
                                    )
                                }
                                innerTextField()
                            }
                        }
                    }
                )
            } else if (type == TopBarType.LearningTopBar.type) {
                Text(text = TopBarType.LearningTopBar.textContent ?: "")
            } else if (type == TopBarType.AIChatTopBar.type) {
                Text(text = TopBarType.AIChatTopBar.textContent ?: "")
            } else if (type == TopBarType.ProfileTopBar.type) {
                Text(text = TopBarType.ProfileTopBar.textContent ?: "")
            } else if(type == TopBarType.NotificationTopBar.type){
                Text(text = TopBarType.NotificationTopBar.textContent ?: "")
            }
        },
        actions = {
            if (type == TopBarType.SearchTopBar.type) {
                IconButton(onClick = onSettingsClick) {
                    Icon(
                        Icons.Default.MoreVert,
                        contentDescription = "More",
                        tint = MaterialTheme.colorScheme.tertiary
                    )
                }
            } else if (type == TopBarType.LearningTopBar.type) {
                IconButton(onClick = onSettingsClick) {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = "Add word",
                        tint = MaterialTheme.colorScheme.tertiary
                    )
                }
                Spacer(modifier = Modifier.padding(end = 6.dp))
            } else if (type == TopBarType.ProfileTopBar.type) {
                IconButton(onClick = onChangeProfileClick) {
                    Icon(
                        Icons.Default.EditNote,
                        contentDescription = "Edit profile",
                        tint = MaterialTheme.colorScheme.tertiary,
                        modifier = Modifier.size(32.dp)
                    )
                }
            } else if (type == TopBarType.AIChatTopBar.type) {
//                IconButton(onClick = onSettingsClick) {
//                    Icon(
//                        Icons.Default.UnfoldMore,
//                        contentDescription = "Unfold chats",
//                        tint = MaterialTheme.colorScheme.tertiary
//                    )
//                }
                ChatsMenu()
            }
            else if (type == TopBarType.NotificationTopBar.type){
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = "Search Notification",
                        tint = MaterialTheme.colorScheme.tertiary,
                        modifier = Modifier.size(32.dp)
                    )
                }
            }
        }
    )
}

sealed class TopBarType(val type: String, val textContent: String? = null) {
    object SearchTopBar : TopBarType(type = "Search")
    object LearningTopBar : TopBarType(type = "Learning", textContent = "Custom Dictionary")
    object AIChatTopBar : TopBarType(type = "AiChat", textContent = "AI Chatbot")
    object ProfileTopBar : TopBarType(type = "Profile", textContent = "Account")
    object NotificationTopBar : TopBarType(type = "Notification", textContent = "Notifications")
}

@Preview(showBackground = true, widthDp = 411, heightDp = 892)
@Composable
fun PreviewTopAppBar() {
    ClientTheme {
        CommonTopBar(
            type = TopBarType.LearningTopBar.type,
            contentText = "Search",
            onSearchTextChanged = {},
            onSettingsClick = {},
            onBackClick = {})
    }
}
