package com.example.client.presentation.pages.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Transgender
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.client.ui.theme.ClientTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GenderPicker(
    options: List<String> = emptyList<String>(),
    onSelectOptionText: (String) -> Unit = {}
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(options[0]) }

    val purpleColor = Color(0xFF7800E6)

    LaunchedEffect(Unit) {
        onSelectOptionText(selectedOptionText)
    }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
    ) {
        TextField(
            readOnly = true,
            value = selectedOptionText,
            onValueChange = { },
            label = { Text("Gender") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Transgender,
                    contentDescription = "Gender picker",
                    tint = purpleColor
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = if (expanded)
                        Icons.Filled.KeyboardArrowUp
                    else
                        Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Dropdown arrow",
                    tint = purpleColor
                )
            },
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth(),
            colors = ExposedDropdownMenuDefaults.textFieldColors(
                focusedLabelColor = Color.Gray.copy(alpha = 0.6f),
                unfocusedLabelColor = Color.Gray.copy(alpha = 0.6f),
                focusedIndicatorColor = Color.Gray.copy(alpha = 0.6f),
                unfocusedIndicatorColor = Color.Gray.copy(alpha = 0.6f),
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White
            ),
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    text = { Text(text = selectionOption) },
                    colors = MenuDefaults.itemColors(

                    ),
                    onClick = {
                        selectedOptionText = selectionOption
                        onSelectOptionText(selectedOptionText)
                        expanded = false
                    },
                    modifier = Modifier
                        .background(Color.White)
                        .border(
                            width = 1.dp,
                            color = Color.LightGray.copy(alpha = 0.6f),
//                            shape = RoundedCornerShape(8.dp)
                        )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGenderPicker() {
    ClientTheme {
        GenderPicker(options = listOf("Male", "Female", "Other"))
    }
}

