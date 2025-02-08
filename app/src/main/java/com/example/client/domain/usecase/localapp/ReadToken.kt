package com.example.client.domain.usecase.localapp

import com.example.client.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadToken(private val localUserManager: LocalUserManager) {
    operator fun invoke(): Flow<String>{
        return localUserManager.readToken()
    }
}