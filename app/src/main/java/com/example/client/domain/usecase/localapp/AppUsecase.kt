package com.example.client.domain.usecase.localapp

data class AppUsecase(
    val saveToken: SaveToken,
    val readToken: ReadToken,
    val saveUser: SaveUser,
    val readUser: ReadUser
)
