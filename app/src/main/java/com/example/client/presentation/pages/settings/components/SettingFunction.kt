package com.example.client.presentation.pages.settings.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.ToggleOff
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.client.presentation.pages.settings.data.SettingFunctionObject
import com.example.client.ui.theme.ClientTheme

@Composable
fun SettingFunction(settingFunctionObject: SettingFunctionObject) {
    Box(modifier = Modifier.fillMaxWidth().padding(12.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start, modifier = Modifier.fillMaxSize()
        ) {
            Icon(settingFunctionObject.leadingIcon, contentDescription = null)
            Spacer(modifier = Modifier.padding(end = 24.dp))
            Text(
                text = settingFunctionObject.content,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.weight(1f)
            )
            if (settingFunctionObject.trailingIcon != null) {
                Icon(settingFunctionObject.trailingIcon, contentDescription = null)
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 411, heightDp = 892)
@Composable
fun PreviewSettingFunction() {
    ClientTheme {
        SettingFunction(
            settingFunctionObject = SettingFunctionObject(
                content = "Change Password",
                leadingIcon = Icons.Default.Key,
                trailingIcon = Icons.Default.ToggleOff
            )
        )
    }
}