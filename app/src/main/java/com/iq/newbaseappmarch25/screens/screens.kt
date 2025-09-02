package com.iq.newbaseappmarch25.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.iq.newbaseappmarch25.R
import com.iq.newbaseappmarch25.model.User
import com.iq.newbaseappmarch25.ui.theme.common.DetailScreen
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
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserListScreen(viewModel: GithubViewModel, onUserClick: (String) -> Unit) {
    val scope = rememberCoroutineScope()
    val users by viewModel.users.collectAsState()

    LaunchedEffect(Unit) {
        scope.launch {
            viewModel.fetchUsers()
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.app_name),
                        fontSize = 20.sp
                    )
                }
            )
        }
    ) { values ->
        LazyColumn(modifier = Modifier.padding(values)) {
            users?.let { myUsers ->
                items(myUsers.size) { index ->
                    UserTile(
                        user = myUsers[index],
                        onClick = { onUserClick(myUsers[index].login) })
                }
            }
        }
    }
}

@Composable
fun UserTile(user: User, onClick: (User) -> Unit) {
    ItemCard(user, onClick)
}

@Composable
fun UserDetailScreen(viewModel: GithubViewModel, username: String, navController: NavController) {
    val scope = rememberCoroutineScope()
    val selectedUser by viewModel.selectedUser.collectAsState()

    LaunchedEffect(username) {
        scope.launch {
            viewModel.fetchUserDetails(username)
        }
    }

    selectedUser?.let {
        DetailScreen(it, onBackClick = {
            navController.popBackStack()
        })
    }
}