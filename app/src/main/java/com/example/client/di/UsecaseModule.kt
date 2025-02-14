package com.example.client.di

import com.example.client.domain.manager.LocalUserManager
import com.example.client.domain.usecase.localapp.AppUsecase
import com.example.client.domain.usecase.localapp.ReadToken
import com.example.client.domain.usecase.localapp.ReadUser
import com.example.client.domain.usecase.localapp.SaveToken
import com.example.client.domain.usecase.localapp.SaveUser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UsecaseModule {
    @Provides
    @Singleton
    fun provideAppUseCase(localUserManager: LocalUserManager): AppUsecase = AppUsecase(
        saveToken = SaveToken(localUserManager),
        readToken = ReadToken(localUserManager),
        saveUser = SaveUser(localUserManager),
        readUser = ReadUser(localUserManager)
    )
}