package com.example.client.domain.usecase.localapp

import com.example.client.domain.manager.LocalUserManager
import com.example.client.domain.model.User

class SaveUser(private val localUserManager: LocalUserManager) {
    suspend operator fun invoke(user: User){
        localUserManager.saveUser(user)
    }
}