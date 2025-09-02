package com.iq.newbaseappmarch25.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iq.newbaseappmarch25.model.User
import com.iq.newbaseappmarch25.repository.GithubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
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
    private val _users = MutableStateFlow<List<User>?>(null)
    val users: StateFlow<List<User>?> get() = _users.asStateFlow()

    private val _selectedUser = MutableStateFlow<User?>(null)
    val selectedUser: StateFlow<User?> get() = _selectedUser.asStateFlow()

    fun fetchUsers() = viewModelScope.launch {
        _users.value = null
        _users.value = repository.getUsers()
    }

    fun fetchUserDetails(username: String) = viewModelScope.launch {
        _selectedUser.value = repository.getUserDetails(username)
    }
}