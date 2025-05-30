package com.iq.talktometranslator.di

import com.iq.talktometranslator.api.GithubApiService
import com.iq.talktometranslator.api.RetrofitClient
import com.iq.talktometranslator.repository.GithubRepository
import com.iq.talktometranslator.viewmodel.GithubViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**********************************************************************
 * Copyright 2025 Innovative Quest Ltd
 *
 * Created by ghouskhan on 20/03/2025.
 * Innovative Quest Ltd
 *
 * Copyright (C) Innovative Quest Ltd All Rights Reserved
 * Any copying or reproduction of this software in strictly prohibited.
 * *********************************************************************/
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideGithubApiService(): GithubApiService = RetrofitClient.instance

    @Provides
    @Singleton
    fun provideGithubRepository(apiService: GithubApiService): GithubRepository = GithubRepository(apiService)
}