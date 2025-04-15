package com.iq.newbaseappmarch25.model

/**********************************************************************
 * Copyright 2025 Innovative Quest Ltd
 *
 * Created by ghouskhan on 20/03/2025.
 * Innovative Quest Ltd
 *
 * Copyright (C) Innovative Quest Ltd All Rights Reserved
 * Any copying or reproduction of this software in strictly prohibited.
 * *********************************************************************/

data class User(
    val id: Int,
    val login: String,
    val avatar_url: String,
    val name: String?,
    val bio: String?,
    val public_repos: Int,
    val followers: Int,
    val following: Int
)