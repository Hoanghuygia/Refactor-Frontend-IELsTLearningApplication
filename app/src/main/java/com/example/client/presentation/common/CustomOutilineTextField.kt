package com.example.client.presentation.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.client.R

@Composable
fun CustomOutlineTextField(
    value: String,
    placeHolder: String,
    height: Int,
    textFieldType: String = "",
    currentTextFieldRequester: FocusRequester? = null,
    nextTextFieldRequester: FocusRequester? = null,
    editableMode: Boolean? = null,
    onValueChange: (String) -> Unit = {},
    onNext: (() -> Unit)? = null
) {
    val purpleColor = Color(0xFF7800E6)
    val focusManager = LocalFocusManager.current

    var unfocusedBorderColor = if (editableMode != false) Color.Gray.copy(alpha = 0.6f) else Color.White
    var focusedBorderColor = if (editableMode != false) Color.Blue.copy(alpha = 0.6f) else Color.White
    var editable = if (editableMode != false) true else false

    OutlinedTextField(
        value = value,
        readOnly = !editable,
        onValueChange = onValueChange,
        placeholder = {
            Text(text = placeHolder, color = Color.Gray.copy(alpha = 0.8f))
        },
        leadingIcon = if (textFieldType != "") {
            {
                IconButton(onClick = {  }) {
                    Icon(
                        painter = when (textFieldType) {
                            TextFieldType.ProfileTextFieldEmail.type -> painterResource(id = R.drawable.mail_24px)
                            TextFieldType.ProfileTextFieldTarget.type -> painterResource(id = R.drawable.target_24px)
                            else -> painterResource(id = R.drawable.info_24px)
                        },
                        contentDescription = placeHolder,
                        tint = purpleColor
                    )
                }
            }
        } else {
            null
        },
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
        keyboardActions = KeyboardActions(onNext = {
//            onNext?.invoke() ?: nextTextFieldRequester?.requestFocus()
            onNext?.invoke() ?: run {
                if (nextTextFieldRequester != null) {
                    nextTextFieldRequester.requestFocus()
                } else {
                    focusManager.clearFocus()
                }
            }
        }),

        modifier = Modifier
            .fillMaxWidth()
            .height(height.dp)
            .then(currentTextFieldRequester?.let { Modifier.focusRequester(it) } ?: Modifier),
        shape = RoundedCornerShape(8.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = focusedBorderColor,
            unfocusedBorderColor = unfocusedBorderColor,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White
        )
    )
}

sealed class TextFieldType(val type: String, val placeHolder: String? = null) {
    object ProfileTextFieldEmail : TextFieldType(type = "ProfileEmail", placeHolder = "Email")
    object ProfileTextFieldTarget : TextFieldType(type = "ProfileTarget", placeHolder = "Target")
}
