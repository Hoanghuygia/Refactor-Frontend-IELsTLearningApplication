package com.example.client.presentation.pages.learning.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.client.domain.model.Word
import com.example.client.presentation.pages.learning.LearningViewModel

@Composable
fun WordsPart(words: List<Word>, deleteOption: Boolean, viewModel: LearningViewModel) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        itemsIndexed(words) { index, word ->
            WordCard(
                word = word,
                deleteOption = deleteOption,
                onClick = { viewModel.updateWord(index) },
                onLongClick = { viewModel.updateDeleteOption() })
        }
    }
}
