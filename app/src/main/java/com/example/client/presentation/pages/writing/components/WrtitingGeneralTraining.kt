package com.example.client.presentation.pages.writing.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.client.presentation.common.TestCard
import com.example.client.presentation.pages.writing.WritingScreenData

@Composable
fun WritingGeneralTraining(){
    val tasksGeneralTraining = WritingScreenData.tasksGeneralTraining

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        items(tasksGeneralTraining) { task ->
            TestCard(modifier = Modifier, test = task)
        }
    }
}