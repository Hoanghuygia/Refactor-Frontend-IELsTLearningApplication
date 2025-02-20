package com.example.client.utils

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

//    fun toggleCheckbox(){
//        _uiState.value = _uiState.value.copy(rememberMe = !re)
//    }


//    init {
//        // init something here in case needed
//    }


//    private fun saveToken(context: Context) {
//        viewModelScope.launch {
//            val accessToken = client.gotrue.currentAccessTokenOrNull()
//            appUsecase.saveToken(accessToken.toString())
//        }
//    }


//            TextField(
//                value = searchText,
//                onValueChange = onSearchTextChanged,
//                placeholder = {
//                    Text(
//                        text = "Search...",
//                        modifier = Modifier.padding(10.dp),
//                        style = MaterialTheme.typography.labelSmall
//                    )
//                },
//                singleLine = true,
//                leadingIcon = {
//                    Icon(Icons.Default.Search, contentDescription = "Search Icon")
//                },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(42.dp)
//                    .clip(RoundedCornerShape(50)),
//                colors = TextFieldDefaults.colors(
//                    focusedTextColor = Color.Black,
//                    unfocusedTextColor = Color.Gray,
//                    disabledTextColor = Color.LightGray,
//                    errorTextColor = Color.Red,
//                    disabledContainerColor = Color.Transparent,
//                    errorContainerColor = Color.Transparent,
//                    focusedContainerColor = Color.LightGray,
//                    unfocusedContainerColor = Color.LightGray
//                ),
//                textStyle = TextStyle(fontSize = 14.sp),
//                shape = RoundedCornerShape(50),
////                contentPadding = PaddingValues(vertical = 8.dp, horizontal = 16.dp)
//            )