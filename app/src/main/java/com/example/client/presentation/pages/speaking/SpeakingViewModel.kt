package com.example.client.presentation.pages.speaking

import androidx.lifecycle.ViewModel
import com.example.client.presentation.pages.reading.ReadingUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SpeakingViewModel @Inject constructor(): ViewModel(){
    private val _uiState = MutableStateFlow(SpeakingUiState())
    val uiState: StateFlow<SpeakingUiState> = _uiState.asStateFlow()

    fun updateSearchTextField(newContent: String){
        _uiState.update { currentState ->
            currentState.copy(searchTextField = newContent)
        }
    }
}