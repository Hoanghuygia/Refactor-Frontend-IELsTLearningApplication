package com.example.client.utils

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp

@Composable
fun HorizontalLine() {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
    ) {
        drawLine(
            color = Color.Black,
            start = Offset(0f, 0f),
            end = Offset(size.width, 0f),
            strokeWidth = 2f
        )
    }
}

//@Composable
//fun HorizontalLine(
//    modifier: Modifier = Modifier,
//    width: Dp = 100.dp,
//    color: Color = Color.Black,
//    strokeWidth: Float = 2f
//) {
//    Canvas(
//        modifier = modifier
//            .width(width)
//            .height(strokeWidth.dp)
//    ) {
//        drawLine(
//            color = color,
//            start = Offset(0f, 0f),
//            end = Offset(size.width, 0f),
//            strokeWidth = strokeWidth,
//            cap = StrokeCap.Round
//        )
//    }
//}

@Composable
fun VerticalLine() {
    Canvas(
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
    ) {
        drawLine(
            color = Color.Black,
            start = Offset(0f, 0f),
            end = Offset(0f, size.height),
            strokeWidth = 2f
        )
    }
}

@Composable
fun DiagonalLine() {
    Canvas(
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
    ) {
        drawLine(
            color = Color.Black,
            start = Offset(0f, 0f),
            end = Offset(size.width, size.height),
            strokeWidth = 2f,
            cap = StrokeCap.Round
        )
    }
}

@Composable
fun CustomLine(
    color: Color = Color.Black,
    strokeWidth: Float = 2f,
    startX: Float,
    startY: Float,
    endX: Float,
    endY: Float
) {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        drawLine(
            color = color,
            start = Offset(startX, startY),
            end = Offset(endX, endY),
            strokeWidth = strokeWidth,
            cap = StrokeCap.Round
        )
    }
}