package com.iq.newbaseappmarch25

import com.iq.newbaseappmarch25.model.User
import com.iq.newbaseappmarch25.repository.GithubRepository
import com.iq.newbaseappmarch25.viewmodel.GithubViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertTrue

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

//    @Test
//    fun `fetchUsers should update users list`() = runBlocking {
////        val mockUsers = listOf(User(1, "user1", "url1", "name1", "bio1", 10, 5, 2))
////        coEvery { mockRepository.getUsers() } returns mockUsers
//
//        viewModel.fetchUsers()
//
//        val users = viewModel.users
//
//        assertEquals(1, users.size)
//    }

//    @Test
//    fun testFetchItems() = runBlocking {
//        viewModel.fetchUsers()
//        val items = viewModel.users
//        assertTrue (items.size > 5)
//    }

//    @Test
//    fun testFetchItemById() = runTest {
//        viewModel.fetchItemById("1")
//        val item = viewModel.selectedItem.first()
//        assertEquals("Item 1", item?.name)
//    }
}