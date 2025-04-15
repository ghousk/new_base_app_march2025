package com.iq.newbaseappmarch25.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iq.newbaseappmarch25.model.User
import com.iq.newbaseappmarch25.repository.GithubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
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
@HiltViewModel
class GithubViewModel @Inject constructor(private val repository: GithubRepository) : ViewModel() {
    private val _users = mutableStateListOf<User>()
    val users: List<User> get() = _users

    private val _selectedUser = mutableStateOf<User?>(null)
    val selectedUser: User? get() = _selectedUser.value

    fun fetchUsers() = viewModelScope.launch {
        _users.clear()
        _users.addAll(repository.getUsers())
    }

    fun fetchUserDetails(username: String) = viewModelScope.launch {
        _selectedUser.value = repository.getUserDetails(username)
    }
}