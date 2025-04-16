package com.iq.newbaseappmarch25

import com.iq.newbaseappmarch25.api.GithubApiService
import com.iq.newbaseappmarch25.model.User
import com.iq.newbaseappmarch25.repository.GithubRepository
import com.iq.newbaseappmarch25.viewmodel.GithubViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
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
class GithubViewModelTest {

    private lateinit var viewModel: GithubViewModel
    private lateinit var repository: GithubRepository
    private val mockApiService = mockk<GithubApiService>()

    @Before
    fun setup() {
        repository = GithubRepository(mockApiService)
        viewModel = GithubViewModel(repository)
    }

    @Test
    fun `fetchUsers should update users list`() = runTest {
        val mockUsers = listOf(User(1, "user1", "url1", "name1", "bio1", 10, 5, 2))
        coEvery { mockApiService.getUsers() } returns mockUsers

        backgroundScope.launch {
            val job = viewModel.fetchUsers()
            job.invokeOnCompletion {
                val users = viewModel.users
                assertEquals(1, users.size)
            }
        }
    }

    @Test
    fun `fetchItemById should fetch a user by the given id`() = runTest {
        val mockUser = User(1, "user1", "url1", "name1", "bio1", 10, 5, 2)
        coEvery { mockApiService.getUserDetails("user1") } returns mockUser

        backgroundScope.launch {
            val job = viewModel.fetchUserDetails("user1")
            job.invokeOnCompletion {
                val user = viewModel.selectedUser
                assertEquals("name1", user?.name)
            }
        }
    }

}