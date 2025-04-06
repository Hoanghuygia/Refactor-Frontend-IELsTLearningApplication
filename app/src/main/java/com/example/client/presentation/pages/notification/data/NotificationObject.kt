package com.example.client.presentation.pages.notification.data

import androidx.annotation.DrawableRes

data class NotificationObject(
    @DrawableRes val fromAvatar: Int,
    var seen:  Boolean = false,
    var name: String,
    var content: String
)
