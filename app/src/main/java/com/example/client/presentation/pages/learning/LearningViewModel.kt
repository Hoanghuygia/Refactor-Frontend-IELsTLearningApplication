package com.example.client.presentation.pages.learning

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LearningViewModel @Inject constructor(): ViewModel(){
    private val _uiState = MutableStateFlow(LearningUiState())
    val uiState: StateFlow<LearningUiState> = _uiState.asStateFlow()

    fun updateSearchTextField(newContent: String){
        _uiState.update { currentState ->
            currentState.copy(searchTextField = newContent)
        }
    }

    fun updateSorted(){
        _uiState.update { currentState ->
            currentState.copy(newest = !currentState.newest)
        }
    }
}