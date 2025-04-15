package com.iq.newbaseappmarch25.repository

import com.iq.newbaseappmarch25.api.GithubApiService
import com.iq.newbaseappmarch25.model.User
import javax.inject.Inject

/**********************************************************************
 * Copyright 2025 Innovative Quest Ltd
 *
 * Created by ghouskhan on 20/03/2025.
 * Innovative Quest Ltd
 *
 * Copyright (C) Innovative Quest Ltd All Rights Reserved
 * Any copying or reproduction of this software in strictly prohibited.
 * *********************************************************************/
class GithubRepository @Inject constructor(private val apiService: GithubApiService) {
    suspend fun getUsers(): List<User> = apiService.getUsers()
    suspend fun getUserDetails(username: String): User = apiService.getUserDetails(username)
}