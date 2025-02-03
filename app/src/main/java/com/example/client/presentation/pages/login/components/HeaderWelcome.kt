package com.example.client.presentation.pages.login.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.client.ui.theme.ClientTheme

@Composable
fun HeaderWelcome() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF002147))
            .fillMaxHeight(0.25f)
//                .background(Color.White.copy(alpha = 0f))
    ) {
        Column(horizontalAlignment = Alignment.Start) {
            Text(
                text = "Welcome to",
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "PeakIELTS!",
                color = Color.White,
                style = MaterialTheme.typography.headlineLarge,
                fontSize = 48.sp
            )
        }
    }

}

@Preview(showBackground = true, widthDp = 411, heightDp = 892)
@Composable
fun PreviewHeaderWelcome() {
    ClientTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            HeaderWelcome()
        }
    }
}