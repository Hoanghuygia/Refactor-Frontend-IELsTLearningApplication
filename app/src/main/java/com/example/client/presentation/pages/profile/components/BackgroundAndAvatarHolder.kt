package com.example.client.presentation.pages.profile.components

import android.net.Uri
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
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.client.presentation.pages.profile.ProfileUiState

@Composable
fun BackgroundAndAvatarHolder(
    showName: String,
    uiState: ProfileUiState,
    tempAvatarUri: Uri?,
    onBgChange: () -> Unit = {},
    onAvatarChange: () -> Unit = {},
    onUpdateAvatar: (Uri, Float, Offset) -> Unit,
    onDismissAvatarCropper: () -> Unit = {}
) {
    val context = LocalContext.current

    val backgroundPainter = if (uiState.bgUri != null) {
        rememberAsyncImagePainter(
            model = ImageRequest.Builder(context)
                .data(uiState.bgUri)
                .build()
        )
    } else {
        painterResource(id = uiState.backgroundImage)
    }

    val avatarPainter = if (uiState.avatarUri != null) {
        rememberAsyncImagePainter(
            model = ImageRequest.Builder(context)
                .data(uiState.avatarUri)
                .build()
        )
    } else {
        painterResource(id = uiState.avatarImage)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(LocalConfiguration.current.screenHeightDp.dp / 4)
    ) {
        Image(
            painter = backgroundPainter,
            contentDescription = "Profile Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
        if (uiState.editableMode) {
            IconButton(onClick = { onBgChange() }, modifier = Modifier.align(Alignment.BottomEnd)) {
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
                    painter = avatarPainter,
                    contentScale = ContentScale.Crop,
                    contentDescription = "Avatar Profile",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape)
                        .border(2.dp, Color.White, CircleShape)
                        .graphicsLayer(
                            scaleX = uiState.avatarScale,
                            scaleY = uiState.avatarScale,
                            translationX = uiState.avatarOffset.x,
                            translationY = uiState.avatarOffset.y
                        )
                )

                if (uiState.editableMode) {
                    IconButton(
                        onClick = { onAvatarChange() },
                        modifier = Modifier.align(Alignment.BottomEnd)
                    ) {
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
                            .background(if (uiState.userStatus) Color.Green else Color.Gray)
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
    if (uiState.showAvatarCropper && tempAvatarUri != null) {
        ImageCropperDialog(
            imageUri = tempAvatarUri,
            onDismiss = { onDismissAvatarCropper() },
            onCropComplete = onUpdateAvatar
        )
    }
}





