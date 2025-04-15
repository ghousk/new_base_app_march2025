package com.iq.newbaseappmarch25.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.iq.newbaseappmarch25.model.User
import com.iq.newbaseappmarch25.ui.theme.common.ItemCard
import com.iq.newbaseappmarch25.viewmodel.GithubViewModel
import kotlinx.coroutines.launch

/**********************************************************************
 * Copyright 2025 Innovative Quest Ltd
 *
 * Created by ghouskhan on 20/03/2025.
 * Innovative Quest Ltd
 *
 * Copyright (C) Innovative Quest Ltd All Rights Reserved
 * Any copying or reproduction of this software in strictly prohibited.
 * *********************************************************************/
@Composable
fun UserListScreen(viewModel: GithubViewModel, onUserClick: (String) -> Unit) {
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        scope.launch {
            viewModel.fetchUsers()
        }
    }

    LazyColumn {
        items(viewModel.users.size) { index ->
            UserTile(user = viewModel.users[index], onClick = { onUserClick(viewModel.users[index].login) })
        }
    }
}

@Composable
fun UserTile(user: User, onClick: (User) -> Unit) {
    ItemCard(user, onClick)
}

@Composable
fun UserDetailScreen(viewModel: GithubViewModel, username: String) {
    val scope = rememberCoroutineScope()

    LaunchedEffect(username) {
        scope.launch {
            viewModel.fetchUserDetails(username)
        }
    }

    val user = viewModel.selectedUser
    if (user != null) {
        Column {
            AsyncImage(
                model = user.avatar_url,
                contentDescription = "User Avatar",
                modifier = Modifier.size(100.dp)
            )
            Text(text = user.name ?: "")
            Text(text = user.bio ?: "")
            Text(text = "Repos: ${user.public_repos}")
            Text(text = "Followers: ${user.followers}")
            Text(text = "Following: ${user.following}")
        }
    }
}