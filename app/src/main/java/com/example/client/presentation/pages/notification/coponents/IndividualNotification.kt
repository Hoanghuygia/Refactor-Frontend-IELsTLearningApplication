package com.example.client.presentation.pages.notification.coponents

import android.app.Notification
import android.graphics.drawable.PaintDrawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.client.R
import com.example.client.presentation.pages.notification.data.NotificationObject
import com.example.client.ui.theme.ClientTheme

@Composable
fun IndividualNotification() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .clickable {}) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.padding(2.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.na),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(90.dp)
                    .clip(
                        CircleShape
                    )
            )
            Box(modifier = Modifier.padding(8.dp)) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(text = "This is the content of the notification.Continue....")
                    Text(text = "19h", style = MaterialTheme.typography.bodyMedium, color = Color.Black.copy(alpha = 0.7f))
                }
            }
        }
        IconButton(onClick = {}, modifier = Modifier.align(Alignment.TopEnd)) {
            Icon(Icons.Default.MoreHoriz, contentDescription = "More")
        }
    }
}

@Preview(showBackground = true, widthDp = 411, heightDp = 892)
@Composable
fun PreviewIndividualNotification() {
    ClientTheme {
        IndividualNotification()
    }
}