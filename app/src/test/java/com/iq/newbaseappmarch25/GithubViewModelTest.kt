package com.iq.newbaseappmarch25

import com.iq.newbaseappmarch25.model.User
import com.iq.newbaseappmarch25.repository.GithubRepository
import com.iq.newbaseappmarch25.viewmodel.GithubViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

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
    private val mockRepository = mockk<GithubRepository>()

    @Before
    fun setup() {
        viewModel = GithubViewModel(mockRepository)
    }

    @Test
    fun `fetchUsers should update users list`() = runTest {
        val mockUsers = listOf(User(1, "user1", "url1", "name1", "bio1", 10, 5, 2))
        coEvery { mockRepository.getUsers() } returns mockUsers

        viewModel.fetchUsers()

        assertEquals(mockUsers, viewModel.users)
    }
}