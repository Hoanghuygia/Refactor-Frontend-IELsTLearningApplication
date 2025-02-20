package com.example.client.presentation.pages.reading.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.client.presentation.pages.reading.ReadingScreenData
import com.example.client.ui.theme.ClientTheme

@Composable
fun ReadingAcademic() {
    val tasksAcademic = ReadingScreenData.tasksAcademic

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        items(tasksAcademic) { task ->
            ReadingAssignment(modifier = Modifier, readingTask = task)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewReadingAcademic() {
    ClientTheme {
        ReadingAcademic()
    }
}