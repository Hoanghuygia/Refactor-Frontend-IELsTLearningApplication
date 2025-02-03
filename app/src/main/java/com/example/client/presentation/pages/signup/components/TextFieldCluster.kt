package com.example.client.presentation.pages.signup.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.client.presentation.common.PasswordTextField
import com.example.client.presentation.pages.signup.SignUpUiState
import com.example.client.presentation.pages.signup.SignUpViewModel
import com.example.client.ui.theme.ClientTheme

@Composable
fun TextFieldCluster(uiState: SignUpUiState, viewModel: SignUpViewModel, modifier: Modifier) {
    val userNameRequester = FocusRequester()
    val emailRequester = FocusRequester()
    val passwordRequester = FocusRequester()
    val confirmPasswordRequester = FocusRequester()


    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
    ) {
        OutlinedTextField(
            value = uiState.username,
            onValueChange = { viewModel.updateTextField(it, "username") },
            placeholder = {
                Text(
                    text = "Enter Your Username",
                    color = Color.Gray.copy(alpha = 0.8f)
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = {
                    emailRequester.requestFocus()
                }
            ),
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(userNameRequester)
                .heightIn(min = 36.dp)
                .padding(bottom = 12.dp),
            shape = RoundedCornerShape(8.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Blue,
                unfocusedBorderColor = Color.Gray
            )
        )

        OutlinedTextField(
            value = uiState.password,
            onValueChange = { viewModel.updateTextField(it, "password") },
            placeholder = {
                Text(
                    text = "Enter Your Email",
                    color = Color.Gray.copy(alpha = 0.8f)
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = {
                    passwordRequester.requestFocus()
                }
            ),
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(emailRequester)
                .heightIn(min = 36.dp)
                .padding(bottom = 12.dp),
            shape = RoundedCornerShape(8.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Blue,
                unfocusedBorderColor = Color.Gray
            )
        )
        PasswordTextField(
            password = uiState.password,
            placeHolderText = "Enter your password",
            onPasswordChange = { newPassword ->
                viewModel.updateTextField(
                    newPassword,
                    "password"
                )
            },
            passwordRequester
        )
        Spacer(modifier = modifier.height(12.dp))
        PasswordTextField(
            password = uiState.confirmPassword,
            placeHolderText = "Confirm your password",
            onPasswordChange = { newPassword ->
                viewModel.updateTextField(
                    newPassword,
                    "confirmPassword"
                )
            },
            confirmPasswordRequester
        )
    }
}

@Preview(showBackground = true, widthDp = 411, heightDp = 892)
@Composable
fun PreviewTextFieldCluster() {
    ClientTheme {
        Box(modifier = Modifier.padding(24.dp)) {
            TextFieldCluster(
                uiState = SignUpUiState(),
                viewModel = SignUpViewModel(),
                modifier = Modifier
            )
        }
    }
}

