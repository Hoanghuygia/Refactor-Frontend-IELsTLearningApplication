package com.example.client.presentation.pages.profile.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.client.R
import com.example.client.ui.theme.ClientTheme

@Composable
fun BackgroundAndAvatarHolder(
    @DrawableRes backgroundImage: Int,
    avatarImage: Painter,
    showName: String,
    status: Boolean,
    editableMode: Boolean
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(LocalConfiguration.current.screenHeightDp.dp / 4)
    ) {
        Image(
            painter = painterResource(id = backgroundImage),
            contentDescription = "Profile Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
        if (editableMode) {
            IconButton(onClick = {}, modifier = Modifier.align(Alignment.BottomEnd)) {
                Icon(
                    Icons.Default.CameraAlt,
                    contentDescription = "Change Background",
                )
            }
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .offset(x = 16.dp, y = 140.dp)
                .align(Alignment.BottomStart)
        ) {
            Box(
                modifier = Modifier.size(140.dp),
                contentAlignment = Alignment.BottomEnd
            ) {
                Image(
                    painter = avatarImage,
                    contentScale = ContentScale.Crop,
                    contentDescription = "Avatar Profile",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape)
                        .border(2.dp, Color.White, CircleShape)
                )

                if (editableMode) {
                    IconButton(onClick = {}, modifier = Modifier.align(Alignment.BottomEnd)) {
                        Icon(
                            Icons.Default.CameraAlt,
                            contentDescription = "Change Avatar",
                        )
                    }
                } else {
                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .clip(CircleShape)
                            .background(if (status) Color.Green else Color.Gray)
                            .border(2.dp, Color.White, CircleShape)
                            .offset(x = (-20).dp, y = (-20).dp)
                    )
                }
            }

            Text(
                text = showName, style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold, modifier = Modifier
                    .padding(top = 12.dp, bottom = 4.dp)
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 411, heightDp = 892)
@Composable
fun PreviewBackgroundAndAvatarHolder() {
    ClientTheme {
        BackgroundAndAvatarHolder(
            backgroundImage = R.drawable.bg,
            avatarImage = painterResource(R.drawable.avatar),
            showName = "Nguyen Pham Diem Quynh",
            status = true,
            editableMode = true
        )
    }
}




