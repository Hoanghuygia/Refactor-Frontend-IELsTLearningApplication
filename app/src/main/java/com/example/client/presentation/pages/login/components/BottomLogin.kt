package com.example.client.presentation.pages.login.components

import ButtonCustom
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.SelectionContainer
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.withAnnotation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.client.R
import com.example.client.presentation.common.DividerWithText
import com.example.client.presentation.common.PasswordTextField
import com.example.client.presentation.common.TextFieldTypePassword
import com.example.client.presentation.navgraph.Route
import com.example.client.presentation.pages.login.LoginUiState
import com.example.client.presentation.pages.login.LoginViewModel
import com.example.client.presentation.pages.login.TextFieldType
import com.example.client.ui.theme.ClientTheme

@OptIn(ExperimentalTextApi::class)
@Composable
fun BottomLogin(uiState: LoginUiState, navController: NavController, loginViewModel: LoginViewModel) {
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
                SelectionContainer {
                    Text(
                        text = stringResource(R.string.log_in),
                        color = Color(0xFF002147),
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                OutlinedTextField(
                    value = uiState.emailTextField,
                    onValueChange = {
                        loginViewModel.updateTextField(
                            it,
                            TextFieldType.EMAIL.type
                        )
                    },
                    placeholder = {
                        Text(
                            text = stringResource(R.string.enter_your_email), color = Color.Gray.copy(alpha = 0.8f)
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
                    type = TextFieldTypePassword.PASSWORD.value,
                    placeHolderText = stringResource(R.string.enter_your_password),
                    onPasswordChange = { newPassword ->
                        loginViewModel.updateTextField(newPassword, TextFieldType.PASSWORD.type)
                    },
                    passwordFocusRequester
                )
                Spacer(modifier = Modifier.height(12.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = uiState.rememberMe,
                        onCheckedChange = { loginViewModel.toggleCheckbox() },
                        modifier = Modifier
                            .padding(start = 4.dp)
                            .size(20.dp),
                        colors = CheckboxDefaults.colors(
                            uncheckedColor = Color.Gray.copy(alpha = 0.6f)
                        )
                    )
                    Text(
                        text = stringResource(R.string.remember_me),
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(horizontal = 12.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = stringResource(R.string.forgot_password),
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
                DividerWithText(text = stringResource(R.string.or_with), lineColor = Color.Gray)
                Spacer(modifier = Modifier.height(28.dp))
                ButtonCustom("Continue with Facebook", "facebook", Color(0xFF1877F2))
                Spacer(modifier = Modifier.height(12.dp))
                ButtonCustom("Continue with Gmail", "gmail", Color(0xFFFFFFFF))
                Spacer(modifier = Modifier.height(24.dp))
//                Text(
//                    text = buildAnnotatedString {
//                        withStyle(style = SpanStyle(color = Color.Black)) {
//                            append("Don't have an account? ")
//                        }
//                        withStyle(style = SpanStyle(color = Color(0xFF1877F2))) {
//                            append("Sign Up")
//                        }
//                    },
//                    style = MaterialTheme.typography.bodyMedium,
//                    modifier = Modifier
//                        .align(Alignment.End)
//                        .padding(end = 12.dp)
//
//                )
                Row(
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(end = 12.dp)
                ) {
                    Text(
                        text = stringResource(R.string.don_t_have_an_account),
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = stringResource(R.string.sign_up),
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(0xFF1877F2),
                        modifier = Modifier.clickable {
                            navController.navigate(Route.SignUpScreen.route)
                        })
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 411, heightDp = 892) // For Samsung Galaxy A23 5G
@Composable
fun PreviewBottomLogin() {
    ClientTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF002147))
        ) {
            BottomLogin(uiState = LoginUiState(), navController = rememberNavController(), loginViewModel = LoginViewModel())
        }
    }
}