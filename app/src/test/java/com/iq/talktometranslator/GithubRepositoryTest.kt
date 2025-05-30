package com.iq.talktometranslator

import com.iq.talktometranslator.api.GithubApiService
import com.iq.talktometranslator.model.User
import com.iq.talktometranslator.repository.GithubRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
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

    @Test
    fun `test get item by id` () = runTest {
        val mockUser = User(1, "user1", "url1", "name1", "bio1", 10, 5, 2)
        coEvery { mockApiService.getUserDetails("user1") } returns mockUser

        val item = repository.getUserDetails("user1")
        assertEquals("name1", item.name)
    }
}