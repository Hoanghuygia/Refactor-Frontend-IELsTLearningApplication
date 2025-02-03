package com.example.client.presentation.pages.login.components

import ButtonCustom
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.client.presentation.common.DividerWithText
import com.example.client.presentation.common.PasswordTextField
import com.example.client.presentation.pages.login.LoginUiState
import com.example.client.presentation.pages.login.LoginViewModel
import com.example.client.ui.theme.ClientTheme

@Composable
fun BottomLogin(uiState: LoginUiState, loginViewModel: LoginViewModel) {
    val emailFocusRequester = FocusRequester()
    val passwordFocusRequester = FocusRequester()

    LaunchedEffect(Unit) {
        emailFocusRequester.requestFocus()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .fillMaxHeight(0.75f),
            shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
//            elevation = 8.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp)
            ) {
                Text(
                    text = "Log In",
                    color = Color(0xFF002147),
                    style = MaterialTheme.typography.headlineLarge
                )
                Spacer(modifier = Modifier.height(12.dp))
                OutlinedTextField(
                    value = uiState.emailTextField,
                    onValueChange = { loginViewModel.updateTextField(it, "email") },
                    placeholder = {
                        Text(
                            text = "Enter your email", color = Color.Gray.copy(alpha = 0.8f)
                        )
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(onNext = {
                        passwordFocusRequester.requestFocus()
                    }),
                    modifier = Modifier
                        .fillMaxWidth()
                        .focusRequester(emailFocusRequester)
//                        .height(48.dp)
                        .heightIn(min = 36.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Blue, unfocusedBorderColor = Color.Gray
                    )
                )
                Spacer(modifier = Modifier.height(12.dp))
                PasswordTextField(
                    uiState.passwordTextField,
                    placeHolderText = "Enter your password",
                    onPasswordChange = { newPassword ->
                        loginViewModel.updateTextField(newPassword, "password")
                    },
                    passwordFocusRequester
                )
                Spacer(modifier = Modifier.height(12.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = false,
                        onCheckedChange = {},
                        modifier = Modifier
                            .padding(start = 4.dp)
                            .size(20.dp),
                        colors = CheckboxDefaults.colors(
                            uncheckedColor = Color.Gray.copy(alpha = 0.6f)
                        )
                    )
                    Text(
                        text = "Remember me",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(horizontal = 12.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "Forgot password?",
                        color = Color.Red,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(horizontal = 6.dp)
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = {}, colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFFD700),
                        contentColor = Color.Black,
                        disabledContainerColor = Color.Gray,
                        disabledContentColor = Color.DarkGray
                    ), shape = RoundedCornerShape(10.dp), modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Login")
                }
                Spacer(modifier = Modifier.height(36.dp))
                DividerWithText(text = "Or With", lineColor = Color.Gray)
                Spacer(modifier = Modifier.height(28.dp))
                ButtonCustom("Continue with Facebook", "facebook", Color(0xFF1877F2))
                Spacer(modifier = Modifier.height(12.dp))
                ButtonCustom("Continue with Gmail", "gmail", Color(0xFFFFFFFF))
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color.Black)) {
                            append("Don't have an account? ")
                        }
                        withStyle(style = SpanStyle(color = Color(0xFF1877F2))) {
                            append("Sign Up")
                        }
                    },
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(end = 12.dp)
                )

            }
        }
    }
}

//@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Preview(showBackground = true, widthDp = 411, heightDp = 892) // For Samsung Galaxy A23 5G
@Composable
fun PreviewBottomLogin() {
    ClientTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF002147))
        ) {
            BottomLogin(uiState = LoginUiState(), loginViewModel = LoginViewModel())
        }
    }
}