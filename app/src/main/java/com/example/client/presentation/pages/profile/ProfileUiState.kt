package com.example.client.presentation.pages.profile

import android.net.Uri
import androidx.annotation.DrawableRes
import androidx.compose.ui.geometry.Offset
import com.example.client.R

data class ProfileUiState(
    var emailTextField: String = "",
    var targetTextField: String = "",
    var editableMode: Boolean = false,
    var userStatus: Boolean = false,
    var optionsGender: List<String> = listOf("Male", "Female", "Other"),
    var selectedOptionText: String = "",
    var selectedDate: String = "",
    @DrawableRes var backgroundImage: Int = R.drawable.avatar,
    @DrawableRes var avatarImage: Int = R.drawable.bg,
    var bgUri: Uri? = null,
    var avatarUri: Uri? = null,
    var showAvatarCropper: Boolean = false,
    var avatarOffset: Offset = Offset.Zero,
    var avatarScale: Float = 1f
)