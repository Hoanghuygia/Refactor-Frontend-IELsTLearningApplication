package com.example.client.presentation.common

import androidx.compose.runtime.Composable
import com.example.client.presentation.pages.listening.components.ListeningAcademic
import com.example.client.presentation.pages.listening.components.ListeningGeneralTraining
import com.example.client.presentation.pages.reading.components.ReadingAcademic
import com.example.client.presentation.pages.reading.components.ReadingGeneralTraining

typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(val title: String, val screen: ComposableFun) {
    object ReadingAcademic : TabItem(title = "Academic", screen = { ReadingAcademic() })
    object ReadingGeneralTraining : TabItem(title = "General Training", screen = { ReadingGeneralTraining() })
    object ListeningAcademic : TabItem(title = "Academic", screen = { ListeningAcademic() })
    object ListeningGeneralTraining : TabItem(title = "General Training", screen = { ListeningGeneralTraining() })
}