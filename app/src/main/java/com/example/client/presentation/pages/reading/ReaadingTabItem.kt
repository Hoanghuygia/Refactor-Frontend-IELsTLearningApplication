package com.example.client.presentation.pages.reading

import androidx.compose.runtime.Composable
import com.example.client.presentation.pages.reading.components.ReadingAcademic
import com.example.client.presentation.pages.reading.components.ReadingGeneralTraining

typealias ComposableFun = @Composable () -> Unit

sealed class ReadingTabItem(val title: String, val screen: ComposableFun) {
    object ReadingAcademic : ReadingTabItem(title = "Academic", screen = { ReadingAcademic() })
    object GeneralTrainingAcademic : ReadingTabItem(title = "General Training", screen = { ReadingGeneralTraining() })
}