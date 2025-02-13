package com.example.client.domain.usecase.localapp

import com.example.client.domain.manager.LocalUserManager

class SaveToken(private val localUserManager: LocalUserManager) {
    suspend operator fun invoke(token: String){
        localUserManager.saveToken(token)
    }
}