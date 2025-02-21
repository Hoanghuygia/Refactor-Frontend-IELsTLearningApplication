package com.example.client.presentation.pages.listening.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.client.presentation.common.TestCard
import com.example.client.presentation.pages.listening.ListeningScreenData

@Composable
fun ListeningGeneralTraining(){
    val tasksGeneralTraining = ListeningScreenData.tasksGeneralTraining

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        items(tasksGeneralTraining) { test ->
            TestCard(modifier = Modifier, test = test)
        }
    }
}