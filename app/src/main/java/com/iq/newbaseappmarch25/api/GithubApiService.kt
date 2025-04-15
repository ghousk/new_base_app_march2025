package com.iq.newbaseappmarch25.api

import com.iq.newbaseappmarch25.model.User
import retrofit2.http.GET
import retrofit2.http.Path

/**********************************************************************
 * Copyright 2025 Innovative Quest Ltd
 *
 * Created by ghouskhan on 20/03/2025.
 * Innovative Quest Ltd
 *
 * Copyright (C) Innovative Quest Ltd All Rights Reserved
 * Any copying or reproduction of this software in strictly prohibited.
 * *********************************************************************/
interface GithubApiService {
    @GET("users")
    suspend fun getUsers(): List<User>

    @GET("users/{username}")
    suspend fun getUserDetails(@Path("username") username: String): User
}