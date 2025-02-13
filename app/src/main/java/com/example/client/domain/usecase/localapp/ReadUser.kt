package com.example.client.domain.usecase.localapp

import com.example.client.domain.manager.LocalUserManager
import com.example.client.domain.model.User
import kotlinx.coroutines.flow.Flow

class ReadUser(private val localUserManager: LocalUserManager) {
    operator fun invoke(): Flow<User?> {
        return localUserManager.readUser()
    }
}