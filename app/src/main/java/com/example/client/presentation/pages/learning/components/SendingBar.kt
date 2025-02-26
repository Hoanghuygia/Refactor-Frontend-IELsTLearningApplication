package com.example.client.presentation.pages.learning.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.rounded.CameraAlt
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.client.presentation.pages.aichat.AiChatUiState
import com.example.client.presentation.pages.aichat.AiChatViewModel
import com.example.client.ui.theme.ClientTheme

@Composable
fun SendingBar(uiState: AiChatUiState, viewModel: AiChatViewModel, modifier: Modifier) {
    val focusRequester: FocusRequester = remember { FocusRequester() }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .navigationBarsPadding()
            .imePadding().height(42.dp)
    ) {
        Icon(
            Icons.Rounded.CameraAlt,
            contentDescription = "Next",
            modifier = modifier.padding(horizontal = 8.dp)
        )

        BasicTextField(
            value = uiState.messageTextField,
            onValueChange = {viewModel.updateMessageTextField(it) },
            modifier = Modifier
                .weight(1f)
                .height(42.dp)
                .clip(RoundedCornerShape(50))
                .background(Color.LightGray.copy(alpha = 0.5f))
                .padding(horizontal = 16.dp, vertical = 8.dp),
            textStyle = TextStyle(
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.tertiary,
                lineHeight = 18.sp
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Send
            ),
            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier.weight(1f),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        if (uiState.messageTextField == "") {
                            Text(
                                "Type a message",
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
        Icon(
            Icons.Filled.PlayArrow,
            contentDescription = "Next",
            modifier = Modifier
                .padding(end = 8.dp)
                .height(42.dp)
                .clickable {})
    }
}

@Preview(showBackground = true, widthDp = 411, heightDp = 892)
@Composable
fun PreviewSendBar() {
    ClientTheme {
        SendingBar(uiState = AiChatUiState(), viewModel = viewModel(), modifier = Modifier)
    }
}