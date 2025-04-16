package com.iq.newbaseappmarch25.ui.theme.common


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.iq.newbaseappmarch25.R
import com.iq.newbaseappmarch25.model.User

@Composable
fun DetailScreen(user: User) {
    Column {
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