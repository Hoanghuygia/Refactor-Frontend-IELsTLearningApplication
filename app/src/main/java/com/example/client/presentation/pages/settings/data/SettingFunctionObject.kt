package com.example.client.presentation.pages.settings.data

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.vector.ImageVector

//sealed class IconResource {
//    data class ImageVectorIcon(val imageVector: ImageVector) : IconResource()
//    data class DrawableIcon(val resId: Int) : IconResource()
//    // Có thể thêm các loại icon khác nếu cần
//}

data class SettingFunctionObject(
    val content: String = "",
    val leadingIcon: ImageVector,
    val trailingIcon: ImageVector? = null,
    val toggleOn : Boolean = false
)
