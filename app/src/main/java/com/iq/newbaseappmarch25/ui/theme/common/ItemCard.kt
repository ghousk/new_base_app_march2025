package com.iq.newbaseappmarch25.ui.theme.common

import android.text.Html
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.iq.newbaseappmarch25.model.User

@Composable
fun ItemCard(user: User, onClick: (User) -> Unit) {
    Card(
        modifier = Modifier.padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable { onClick(user) },
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(Modifier.padding(8.dp)) {
                AsyncImage(
                    model = user.avatar_url,
                    contentDescription = "User Avatar",
                    modifier = Modifier.size(100.dp)
                        .padding(2.dp),
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Crop,
                    alpha = 1.0F
                )
            }
            Column(Modifier.padding(8.dp)) {
                user.name?.let { name ->
                    Text(
                        text = Html.fromHtml(name, Html.FROM_HTML_MODE_LEGACY).toString(),
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.onSurface,
                    )
                } ?: run { Text(
                    text = "Default User Name",
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onSurface,
                ) }
                Text(
                    text = Html.fromHtml(user.login, Html.FROM_HTML_MODE_LEGACY).toString(),
                    style = MaterialTheme.typography.bodyMedium,
                )
                user.bio?.let {
                    Text(
                        text = Html.fromHtml(it, Html.FROM_HTML_MODE_LEGACY).toString(),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }?: run{
                    Text(
                        text = "Default User Bio",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

        }
    }

}