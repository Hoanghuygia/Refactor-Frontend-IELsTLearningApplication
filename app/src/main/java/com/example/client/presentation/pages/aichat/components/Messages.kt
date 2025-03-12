package com.example.client.presentation.pages.aichat.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.client.domain.model.Message
import com.example.client.presentation.pages.aichat.AiChatScreenData
import com.example.client.ui.theme.ClientTheme

@Composable
fun Messages(messages: List<Message>, modifier: Modifier) {
    val listState = rememberLazyListState()

    LaunchedEffect(messages.size) {
        if (messages.isNotEmpty()) {
            listState.animateScrollToItem(messages.lastIndex)
        }
    }

    LazyColumn(modifier = modifier.fillMaxSize(), state = listState, reverseLayout = false) {
        items(messages) { message ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = if (message.entity == 1) 20.dp else 0.dp,
                        end = if (message.entity == 0) 20.dp else 0.dp
                    ), horizontalArrangement =
                if (message.entity == 0) { // 0 is AI, 1 is user
                    Arrangement.Start
                } else {
                    Arrangement.End
                }
            ) {
                MessageComponent(message = message)
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 411, heightDp = 892)
@Composable
fun PreviewMessages(){
    ClientTheme {
        Messages(AiChatScreenData.messages, modifier = Modifier)
    }
}