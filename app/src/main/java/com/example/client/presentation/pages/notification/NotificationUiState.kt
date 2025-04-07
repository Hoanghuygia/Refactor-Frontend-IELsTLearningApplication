package com.example.client.presentation.pages.notification

import android.app.Notification
import com.example.client.presentation.pages.notification.data.NotificationObject

data class NotificationUiState (
    var test: String = "",
    var notifications: List<NotificationObject> = emptyList<NotificationObject>()
)