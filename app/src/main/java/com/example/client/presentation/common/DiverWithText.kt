package com.example.client.presentation.common

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.Dp


@Composable
fun DividerWithText(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle.Default,
    lineColor: Color = Color.Black,
    lineThickness: Float = 2f,
    horizontalPadding: Dp = 16.dp,
    textPadding: Dp = 8.dp
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Canvas(
            modifier = Modifier
                .weight(1f)
                .height(lineThickness.dp)
                .padding(end = textPadding)
        ) {
            drawLine(
                color = lineColor,
                start = Offset(0f, size.height / 2),
                end = Offset(size.width, size.height / 2),
                strokeWidth = lineThickness
            )
        }
        Text(
            text = text,
            style = textStyle,
            modifier = Modifier.padding(horizontal = horizontalPadding)
        )
        Canvas(
            modifier = Modifier
                .weight(1f)
                .height(lineThickness.dp)
                .padding(start = textPadding)
        ) {
            drawLine(
                color = lineColor,
                start = Offset(0f, size.height / 2),
                end = Offset(size.width, size.height / 2),
                strokeWidth = lineThickness
            )
        }
    }
}