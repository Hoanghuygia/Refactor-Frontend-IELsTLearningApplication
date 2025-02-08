package com.example.client.domain.manager

import kotlinx.coroutines.flow.Flow

    interface LocalUserManager {
        suspend fun saveToken(token: String? = null)
        fun readToken(): Flow<String>
    }