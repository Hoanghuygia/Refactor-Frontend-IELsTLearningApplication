package com.example.client.presentation.pages.learning

import android.util.Log
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
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

    fun updateShowDialog(){
        _uiState.update { currentState ->
            currentState.copy(showDialog = !currentState.showDialog)
        }
    }

    fun updateDeleteOption(){
        _uiState.update { currentState ->
            currentState.copy(deleteOption = !currentState.deleteOption)
        }
    }

    fun updateWord(index: Int){
        updateShowDialog()
        Log.i("update word", "Go here ${uiState.value.showDialog}")
        _uiState.update { currentState ->
            currentState.copy(
                wordTextField = currentState.words[index].word,
                wordTypeTextField = currentState.words[index].type,
                wordMeaningTextField = currentState.words[index].meaning
            )
        }
    }

    fun addWord() {
        val sdf = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
        val newWord = Word(
            word = uiState.value.wordTextField,
            type = uiState.value.wordTypeTextField,
            meaning = uiState.value.wordMeaningTextField,
            createdAt = sdf.format(System.currentTimeMillis())
        )
        _uiState.update { currentState ->
            currentState.copy(
                words = currentState.words + newWord,
                wordTextField = "",
                wordTypeTextField = "",
                wordMeaningTextField = ""
            )
        }
    }
}