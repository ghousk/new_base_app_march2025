package com.iq.newbaseappmarch25

import com.iq.newbaseappmarch25.api.GithubApiService
import com.iq.newbaseappmarch25.model.User
import com.iq.newbaseappmarch25.repository.GithubRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

/**********************************************************************
 * Copyright 2025 Innovative Quest Ltd
 *
 * Created by ghouskhan on 20/03/2025.
 * Innovative Quest Ltd
 *
 * Copyright (C) Innovative Quest Ltd All Rights Reserved
 * Any copying or reproduction of this software in strictly prohibited.
 * *********************************************************************/
class GithubRepositoryTest {
    private lateinit var repository: GithubRepository
    private val mockApiService = mockk<GithubApiService>()

    @Before
    fun setup() {
        repository = GithubRepository(mockApiService)
    }

    @Test
    fun `getUsers should return users from API`() = runTest {
        val mockUsers = listOf(User(1, "user1", "url1", "name1", "bio1", 10, 5, 2))
        coEvery { mockApiService.getUsers() } returns mockUsers

        val result = repository.getUsers()

        assertEquals(mockUsers, result)
    }
}