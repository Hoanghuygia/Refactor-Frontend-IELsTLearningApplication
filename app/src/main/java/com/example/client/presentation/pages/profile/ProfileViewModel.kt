package com.example.client.presentation.pages.profile

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(): ViewModel() {
    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    fun toggleEditMode(){
        _uiState.update { currentState ->
            currentState.copy(editableMode = !currentState.editableMode)
        }
    }

    fun changeGenderPicker(selectedOptionText: String){
        _uiState.update { currentState ->
            currentState.copy(selectedOptionText = selectedOptionText)
        }
    }

    fun changeDOB(selectedDate: String){
        _uiState.update { currentState ->
            currentState.copy(selectedDate = selectedDate)
        }
    }
}