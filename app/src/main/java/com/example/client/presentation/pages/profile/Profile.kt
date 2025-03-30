package com.example.client.presentation.pages.profile

import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.client.R
import com.example.client.presentation.common.CommonTopBar
import com.example.client.presentation.common.CustomOutlineTextField
import com.example.client.presentation.common.DatePickerFieldToModal
import com.example.client.presentation.common.TextFieldType
import com.example.client.presentation.common.TopBarType
import com.example.client.presentation.pages.profile.components.BackgroundAndAvatarHolder
import com.example.client.presentation.pages.profile.components.GenderPicker
import com.example.client.ui.theme.ClientTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun ProfileScreen(viewModel: ProfileViewModel = hiltViewModel(), navController: NavController) {
    val uiState = viewModel.uiState.collectAsState().value

    var showAvatarCropper by remember { mutableStateOf(false) }
    var tempAvatarUri by remember { mutableStateOf<Uri?>(null) }

    val backgroundPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        viewModel.updateBackgroundImage(uri);
    }
    val avatarPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        tempAvatarUri = uri
        viewModel.updateShowAvatarCropper()
        Log.d("tempURi", tempAvatarUri.toString())
        Log.d("avatarcropper", uiState.showAvatarCropper.toString())
//        showAvatarCropper = true
//        viewModel.updateAvatarImage(uri);
    }

    val dobRequester = FocusRequester()
    val emailRequester = FocusRequester()
    val targetRequester = FocusRequester()

    Scaffold(
        topBar = {
            CommonTopBar(
                type = TopBarType.ProfileTopBar.type,
                contentText = TopBarType.ProfileTopBar.textContent.toString(),
                onChangeProfileClick = { viewModel.toggleEditMode() }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                BackgroundAndAvatarHolder(
                    backgroundImage = uiState.backgroundImage,
                    avatarImage = painterResource(R.drawable.avatar),
                    showName = "Nguyễn Phạm Diễm Quỳnh",
                    status = uiState.userStatus,
                    editableMode = uiState.editableMode,
                    uiState = uiState,
                    tempAvatarUri = tempAvatarUri,
                    showAvatarCropper = uiState.showAvatarCropper,
                    onBgChange = {
                        backgroundPickerLauncher.launch("image/*")
                    },
                    onAvatarChange = {
                        avatarPickerLauncher.launch("image/*")
                    },
                    onUpdateAvatar = {uri, scale, offset ->
                        viewModel.updateAvatarImage2(uri, scale, offset)
                    },
                    onDismissAvatarCropper = { viewModel.updateShowAvatarCropper() }
                )
                Spacer(modifier = Modifier.height(140.dp))
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.padding(20.dp)
                ) {
                    GenderPicker(
                        options = uiState.optionsGender,
                        uiState.editableMode,
                        onSelectOptionText = { viewModel.changeGenderPicker(it) })
                    DatePickerFieldToModal(
                        modifier = Modifier,
                        uiState.editableMode,
                        currentRequester = dobRequester,
                        nextRequester = emailRequester,
                        onSelectDOB = { viewModel.changeDOB(it) })
                    Spacer(modifier = Modifier.height(12.dp))
                    CustomOutlineTextField(
                        value = uiState.emailTextField,
                        placeHolder = "Email",
                        height = 52,
                        textFieldType = TextFieldType.ProfileTextFieldEmail.type,
                        currentTextFieldRequester = emailRequester,
                        nextTextFieldRequester = targetRequester,
                        editableMode = uiState.editableMode,
                        onValueChange = { viewModel.updateEmail(it) })
                    Spacer(modifier = Modifier.height(12.dp))
                    CustomOutlineTextField(
                        value = uiState.targetTextField,
                        placeHolder = "Target",
                        height = 52,
                        textFieldType = TextFieldType.ProfileTextFieldTarget.type,
                        currentTextFieldRequester = targetRequester,
                        editableMode = uiState.editableMode,
                        onValueChange = { viewModel.updateTarget(it) })
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 411, heightDp = 892)
@Composable
fun PreviewProfileScreen() {
    ClientTheme {
        ProfileScreen(navController = rememberNavController())
    }
}