package com.example.client.presentation.pages.learning

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.client.domain.model.Word
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.SimpleDateFormat
import javax.inject.Inject

@HiltViewModel
class LearningViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(LearningUiState())
    val uiState: StateFlow<LearningUiState> = _uiState.asStateFlow()

    init {
        uiState.value.words = LearningScreenData.words
    }

    fun updateSearchTextField(newContent: String) {
        _uiState.update { currentState ->
            currentState.copy(searchTextField = newContent)
        }
    }

    fun updateSorted() {
        _uiState.update { currentState ->
            currentState.copy(newest = !currentState.newest)
        }
    }

    fun updateTextFieldAddWord(newContent: String, type: String) {
        val currentState = _uiState.value
        _uiState.value = when (type) {
            "new_word" -> currentState.copy(wordTextField = newContent)
            "word_type" -> currentState.copy(wordTypeTextField = newContent)
            "word_meaning" -> currentState.copy(wordMeaningTextField = newContent)
            else -> currentState
        }
    }

    fun updateShowDialog() {
        _uiState.update { currentState ->
            currentState.copy(showDialog = !currentState.showDialog)
        }
    }

    fun updateDeleteModalStatus() {
        _uiState.update { currentState ->
            currentState.copy(deleteModal = !currentState.deleteModal)
        }
    }

    fun updateDeleteOption() {
        _uiState.update { currentState ->
            currentState.copy(
                deleteOption = !currentState.deleteOption,
                deleteModal = !currentState.deleteModal
            )
        }
    }

    fun updateWord(index: Int) {
        updateShowDialog()
        Log.i("update word", "Go here ${uiState.value.showDialog}")
        _uiState.update { currentState ->
            currentState.copy(
                wordTextField = currentState.words[index].word,
                wordTypeTextField = currentState.words[index].type,
                wordMeaningTextField = currentState.words[index].meaning,
                updateWordIndex = index
            )
        }
    }

    fun addOrUpdateWord(index: Int? = null) {
        val sdf = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
        val currentTime = sdf.format(System.currentTimeMillis())

        val newWord = Word(
            word = uiState.value.wordTextField,
            type = uiState.value.wordTypeTextField,
            meaning = uiState.value.wordMeaningTextField,
            createdAt = if (index == null) currentTime else uiState.value.words[index].createdAt,
            updatedAt = if (index != null) currentTime else ""
        )

        _uiState.update { currentState ->
            val updatedWords = if (index == null) {
                currentState.words + newWord
            } else {
                currentState.words.toMutableList().apply {
                    this[index] = newWord
                }
            }

            currentState.copy(
                words = updatedWords,
                wordTextField = "",
                wordTypeTextField = "",
                wordMeaningTextField = "",
            )
        }
    }

    fun updateNullIndexWord() {
        _uiState.update { currentState ->
            currentState.copy(updateWordIndex = null)
        }
    }

//    fun toggleWordSelection(index: Int) {
//        val currentWords = _uiState.value.words.toMutableList()
//        if (index in currentWords.indices) {
//            val selectedWord = currentWords[index]
//            selectedWord.isSelected = !selectedWord.isSelected
//            _uiState.value = _uiState.value.copy(words = currentWords)
//        }
//    }

    fun toggleWordSelection(index: Int) {
        val currentWords = _uiState.value.words.toMutableList()
        if (index in currentWords.indices) {
            val selectedWord = currentWords[index] // Compose do not see it when we change directly as above
            val updatedWord = selectedWord.copy(isSelected = !selectedWord.isSelected)
            currentWords[index] = updatedWord
            _uiState.value = _uiState.value.copy(words = currentWords)
        }
        updateDeletedListWord(index)
    }

    fun updateDeletedListWord(index: Int) {
        val currentDeletedIndexList = _uiState.value.deleteWordIndexList.toMutableList()
        currentDeletedIndexList.add(index)
        _uiState.value = _uiState.value.copy(
            deleteWordIndexList = currentDeletedIndexList
        )
    }

    fun deleteWordWithIndex(indexDeleted: List<Int>){
        val currentWords = uiState.value.words.toMutableList()
        val sortedIndices = indexDeleted.sortedDescending()

        sortedIndices.forEach { index ->
            if (index in currentWords.indices) {
                currentWords.removeAt(index)
            }
        }

        _uiState.value = _uiState.value.copy(words = currentWords)
    }


    private fun isWordInListIgnoreCase(wordToCheck: String): Boolean {
        return LearningScreenData.words.any { it.word.equals(wordToCheck, ignoreCase = true) }
    }
}