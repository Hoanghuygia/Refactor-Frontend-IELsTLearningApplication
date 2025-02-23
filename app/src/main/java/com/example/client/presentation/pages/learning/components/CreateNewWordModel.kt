package com.example.client.presentation.pages.learning.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.example.client.presentation.common.CustomOutlineTextField
import com.example.client.presentation.pages.learning.LearningViewModel
import com.example.client.ui.theme.ClientTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateNewWordModal(
    word: String,
    wordType: String,
    wordMeaning: String,
    viewModel: LearningViewModel,
    onDismissRequest: () -> Unit,
    onConfirmRequest: () -> Unit,
) {
    BasicAlertDialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)
    ) {
        val wordTypeRequester = FocusRequester()
        val wordMeaningRequester = FocusRequester()

        Surface(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .size(width = 325.dp, height = 500.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(
                    "Create a new word",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold
                )
                CustomOutlineTextField(
                    value = word,
                    placeHolder = "Enter a new word",
                    height = 52,
                    nextTextFieldRequester = wordTypeRequester,
                    onValueChange = { viewModel.updateTextFieldAddWord(it, "new_word") })
                CustomOutlineTextField(
                    value = wordType,
                    placeHolder = "Enter type of word",
                    height = 52,
                    nextTextFieldRequester = wordMeaningRequester,
                    onValueChange = { viewModel.updateTextFieldAddWord(it, "word_type") })
                CustomOutlineTextField(
                    value = wordMeaning,
                    placeHolder = "Enter meaning of word",
                    height = 200,
                    onValueChange = { viewModel.updateTextFieldAddWord(it, "word_meaning") })
                Button(
                    onClick = { viewModel.addWord() },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFFD700),
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Create", fontSize = 23.sp)
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 411, heightDp = 892)
@Composable
fun PreviewCreateWordModal() {
    ClientTheme {
        CreateNewWordModal(
            "",
            "",
            "",
            onConfirmRequest = {},
            onDismissRequest = {},
            viewModel = LearningViewModel()
        )
    }
}