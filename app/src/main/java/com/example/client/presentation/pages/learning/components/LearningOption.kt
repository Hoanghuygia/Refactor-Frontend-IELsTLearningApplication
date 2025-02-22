package com.example.client.presentation.pages.learning.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material.icons.filled.Sync
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.client.ui.theme.ClientTheme

@Composable
fun LearningOption() {
    val lineThickness: Float = 2f

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .border(
                width = 1.dp,
                color = Color.LightGray,
            )
    ) {
        IconButton(onClick = {}) {
            Icon(
                Icons.Default.FilterAlt,
                contentDescription = "Filter"
            )
        }
        Canvas(
            modifier = Modifier
                .width(lineThickness.dp)
                .height(36.dp)
        ) {
            drawLine(
                color = Color.Black,
                start = Offset(0f, 0f),
                end = Offset(0f, size.height), // size here is the canvas size
                strokeWidth = lineThickness
            )
        }
        Box(
            modifier = Modifier.weight(1f).padding(start = 6.dp)
        ) {
            Text(text = "Date added (newest)", style = MaterialTheme.typography.headlineSmall.copy(fontSize = 14.sp))
        }
        IconButton(onClick = {}) {
            Icon(
                Icons.Default.Sync,
                contentDescription = "Swap"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLearningOption() {
    ClientTheme {
        LearningOption()
    }
}