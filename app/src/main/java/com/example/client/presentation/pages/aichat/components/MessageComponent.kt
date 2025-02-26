package com.example.client.presentation.pages.aichat.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.client.domain.model.Message
import com.example.client.ui.theme.ClientTheme


@Composable
fun MessageComponent(message: Message, modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = if (message.entity == 1) {
                Color(0xFFFFE599)
            } else {
                Color(0xFF002147)
            }
        ),
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
            .padding(12.dp)
            .wrapContentSize()
    ) {
        Column(modifier.padding(12.dp)) {
            val textColor = if (message.entity == 0) {
                Color.White
            } else {
                Color.Black
            }
            Text(text = message.message, color = textColor)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMessage() {
    ClientTheme {
        MessageComponent(Message(message = "ABC ILOV U", timestamp = "1:29", entity = 0))
    }
}