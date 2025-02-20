package com.example.client.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
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
import com.example.client.ui.theme.ClientTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonTopBar(
    type: String?,
    contentText: String,
    onSearchTextChanged: (String) -> Unit,
    onBackClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(
                    Icons.Default.ArrowBackIosNew,
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.tertiary
                )
            }
        },
        title = {
            if (type != null) {
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
                        color = MaterialTheme.colorScheme.tertiary
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
                            Box(modifier = Modifier
                                .weight(1f)
                                .padding(start = 6.dp)) {
                                if (contentText.isEmpty()) {
                                    Text(
                                        text = "Search...",
                                        color = MaterialTheme.colorScheme.tertiary,
                                        fontSize = 14.sp,
                                        modifier = Modifier.padding(bottom = 2.dp)
                                    )
                                }
                                innerTextField()
                            }
                        }
                    }
                )
            }
        },
        actions = {
            if (type != null) {
                IconButton(onClick = onSettingsClick) {
                    Icon(
                        Icons.Default.MoreVert,
                        contentDescription = "More",
                        tint = MaterialTheme.colorScheme.tertiary
                    )
                }
            }
        }
    )
}


@Preview(showBackground = true, widthDp = 411, heightDp = 892)
@Composable
fun PreviewTopAppBar() {
    ClientTheme {
        CommonTopBar(
            type = "abc",
            contentText = "Search",
            onSearchTextChanged = {},
            onSettingsClick = {},
            onBackClick = {})
    }
}
