package com.example.client.presentation.pages.signup

import ButtonCustom
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.client.presentation.common.DividerWithText
import com.example.client.presentation.pages.signup.components.TextFieldCluster
import com.example.client.ui.theme.ClientTheme

@Composable
fun SignUpScreen(viewModel: SignUpViewModel = hiltViewModel(), modifier: Modifier) {
    val uiState = viewModel.uiState.collectAsState().value

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF002147))
    ) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(0.85f)
                .align(Alignment.BottomEnd),
            shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
        ) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(24.dp)
            ) {
                Text(
                    text = "Sign Up",
                    color = Color(0xFF002147),
                    style = MaterialTheme.typography.headlineLarge,
                    modifier = modifier.padding(bottom = 24.dp)
                )
                TextFieldCluster(uiState = uiState, viewModel = viewModel, modifier = modifier)
                Spacer(modifier = modifier.height(24.dp))
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
                Spacer(modifier = modifier.height(36.dp))
                DividerWithText(text = "Or With", lineColor = Color.Gray)
                Spacer(modifier = Modifier.height(28.dp))
                ButtonCustom("Continue with Facebook", "facebook", Color(0xFF1877F2))
                Spacer(modifier = Modifier.height(12.dp))
                ButtonCustom("Continue with Gmail", "gmail", Color(0xFFFFFFFF))
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 411, heightDp = 892)
@Composable
fun PreviewSignUpScreen(){
    ClientTheme {
        SignUpScreen(modifier = Modifier)
    }
}