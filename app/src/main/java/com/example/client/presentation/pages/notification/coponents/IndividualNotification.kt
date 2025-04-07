package com.example.client.presentation.pages.notification.coponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.client.R
import com.example.client.presentation.pages.notification.data.NotificationObject
import com.example.client.ui.theme.ClientTheme
import com.example.client.utils.UtilFunctions

@Composable
fun IndividualNotification(notification: NotificationObject, index: Int, onUpdateSeenState: (Int) -> Unit) {
    var bgColor = if (notification.seen) Color.White else Color(0xFFE7F3FF)

    Box(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            onUpdateSeenState(index)
        }
        .background(color = bgColor)
        .padding(7.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    painter = painterResource(id = notification.fromAvatar),
                    contentDescription = UtilFunctions.truncateToWords(notification.content, 15),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape)
                )
                Box(modifier = Modifier.padding(8.dp)) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = buildAnnotatedString {
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                    append("Anonymous member ")
                                }
                                append("is said about your answer to a question...")
                            }
                        )
                        Text(
                            text = "19h",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Black.copy(alpha = 0.7f)
                        )
                    }
                }
            }
            Box(
                modifier = Modifier
                    .height(70.dp)
                    .align(Alignment.Top)
            ) {
                IconButton(
                    onClick = {},
                    modifier = Modifier.align(Alignment.TopEnd)
                ) {
                    Icon(Icons.Default.MoreHoriz, contentDescription = "More")
                }
            }

        }
    }
}

//@Preview(showBackground = true, widthDp = 411, heightDp = 892)
//@Composable
//fun PreviewIndividualNotification() {
//    ClientTheme {
//        IndividualNotification(
//            notification = NotificationObject(
//                fromAvatar = R.drawable.na,
//                seen = false,
//                name = "Ngoc Anh",
//                content = "is said about your answer to a question..."
//            )
//        )
//    }
//}