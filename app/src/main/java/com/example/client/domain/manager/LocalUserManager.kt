package com.example.client.domain.manager

import com.example.client.domain.model.User
import kotlinx.coroutines.flow.Flow

    interface LocalUserManager {
        suspend fun saveToken(token: String? = null)
        fun readToken(): Flow<String>
        suspend fun saveUser(user: User)
        fun readUser(): Flow<User?>
    }