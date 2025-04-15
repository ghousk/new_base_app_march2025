package com.iq.newbaseappmarch25.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**********************************************************************
 * Copyright 2025 Innovative Quest Ltd
 *
 * Created by ghouskhan on 20/03/2025.
 * Innovative Quest Ltd
 *
 * Copyright (C) Innovative Quest Ltd All Rights Reserved
 * Any copying or reproduction of this software in strictly prohibited.
 * *********************************************************************/
object RetrofitClient {
    private const val BASE_URL = "https://api.github.com/"

    val instance: GithubApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build())
            .build()
            .create(GithubApiService::class.java)
    }
}