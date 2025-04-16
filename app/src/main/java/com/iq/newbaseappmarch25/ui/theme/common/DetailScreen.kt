package com.iq.newbaseappmarch25.ui.theme.common


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.iq.newbaseappmarch25.R
import com.iq.newbaseappmarch25.model.User

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(user: User, onBackClick: () -> Unit) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = user.name ?: run { user.login },
                        fontSize = 20.sp
                )},
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column ( modifier = Modifier
            .padding(padding)
            .padding(16.dp)
        ) {
            AsyncImage(
                model = user.avatar_url,
                contentDescription = "User Avatar",
                modifier = Modifier
                    .fillMaxWidth()
            )
            Column (Modifier
                .padding(8.dp)
                .verticalScroll(rememberScrollState())
            ){
                Text(text = user.name ?: "",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onSurface)
                Text(text = user.bio ?: "")
                Text(text = "Repos: ${user.public_repos}",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface)
                Text(text = "Followers: ${user.followers}",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface)
                Text(text = "Following: ${user.following}",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface)
                Text(text = LocalContext.current.getString(R.string.lorem_ipsum),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(0.dp,8.dp, 0.dp, 0.dp))
            }

        }
    }

}