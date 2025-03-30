package com.example.client.presentation.pages.profile

import android.net.Uri
import android.util.Log
import androidx.compose.ui.geometry.Offset
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

    fun updateEmail(email: String){
        _uiState.update { currentState ->
            currentState.copy(emailTextField = email)
        }
    }

    fun updateTarget(target: String){
        _uiState.update { currentState ->
            currentState.copy(targetTextField = target)
        }
    }

    fun updateAvatarImage(uri: Uri?){
        _uiState.update { currentState ->
            currentState.copy(avatarUri = uri)
        }
    }

    fun updateBackgroundImage(uri: Uri?){
        _uiState.update { currentState ->
            currentState.copy(bgUri = uri)
        }
    }
//
//    fun updateShowAvatarCropper(){
//        _uiState.update { currentState ->
//            Log.d("updateShowAvatarCropper", "New state: $newState")
//            currentState.copy(showAvatarCropper = !currentState.showAvatarCropper)
//        }
//    }

    fun updateShowAvatarCropper(){
        _uiState.update { currentState ->
            val newState = !currentState.showAvatarCropper
            Log.d("updateShowAvatarCropper", "New state: $newState")
            currentState.copy(showAvatarCropper = newState)
        }
    }

    fun updateAvatarImage2(uri: Uri, scale: Float = 1f, offset: Offset = Offset.Zero) {
        _uiState.update { currentState ->
            currentState.copy(
                avatarUri = uri,
                avatarScale = scale,
                avatarOffset = offset
            )
        }
        updateShowAvatarCropper()
    }
}