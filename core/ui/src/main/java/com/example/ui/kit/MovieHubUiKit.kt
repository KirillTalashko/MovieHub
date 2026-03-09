package com.example.ui.kit

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import java.util.Locale

@Composable
fun MovieHubAvatar(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
        Row(
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
                .background(
                    Brush.linearGradient(
                        listOf(Color(0xFF2B2D37), Color(0xFF0F111C))
                    )
                )
                .clickable(onClick = onClick),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = "Profile",
                tint = MovieHubUiKitColors.TextPrimary,
                modifier = Modifier.size(18.dp)
            )
        }
    }
}

@Composable
fun MovieHubSearchField(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = query,
        onValueChange = onQueryChange,
        modifier = modifier.fillMaxWidth(),
        singleLine = true,
        placeholder = {
            Text("Search", color = MovieHubUiKitColors.TextSecondary)
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = null,
                tint = MovieHubUiKitColors.TextSecondary
            )
        },
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = MovieHubUiKitColors.Surface,
            unfocusedContainerColor = MovieHubUiKitColors.Surface,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedTextColor = MovieHubUiKitColors.TextPrimary,
            unfocusedTextColor = MovieHubUiKitColors.TextPrimary,
            cursorColor = MovieHubUiKitColors.Accent
        )
    )
}

@Composable
fun MovieHubFilterChip(
    title: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val bg = if (selected) MovieHubUiKitColors.SurfaceSelected else MovieHubUiKitColors.SurfaceSoft

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(14.dp))
            .background(bg)
            .clickable(onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Icon(
            imageVector = when (title) {
                "Top IMDb" -> Icons.Filled.Star
                "Search" -> Icons.Filled.Search
                "Profile" -> Icons.Filled.Person
                else -> Icons.Filled.Home
            },
            contentDescription = title,
            tint = MovieHubUiKitColors.TextPrimary,
            modifier = Modifier.size(18.dp)
        )
        Text(
            text = title,
            style = MaterialTheme.typography.bodySmall,
            color = MovieHubUiKitColors.TextPrimary
        )
    }
}

@Composable
fun MovieHubPosterCard(
    title: String,
    subtitle: String,
    rating: Float,
    startColor: Color,
    endColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(14.dp))
            .background(
                brush = Brush.verticalGradient(listOf(startColor, endColor))
            )
            .clickable(onClick = onClick)
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = title,
            color = MovieHubUiKitColors.TextPrimary,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = subtitle,
            color = MovieHubUiKitColors.TextSecondary,
            style = MaterialTheme.typography.labelSmall
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = null,
                tint = MovieHubUiKitColors.Rating,
                modifier = Modifier.size(14.dp)
            )
            Text(
                text = String.format(Locale.US, "%.1f", rating),
                color = MovieHubUiKitColors.TextPrimary,
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}

@Composable
fun MovieHubBottomBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .background(MovieHubUiKitColors.Surface)
            .navigationBarsPadding()
            .padding(vertical = 14.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(Icons.Filled.Home, contentDescription = "Home", tint = MovieHubUiKitColors.TextPrimary)
        Icon(Icons.Filled.Star, contentDescription = "Top", tint = MovieHubUiKitColors.TextSecondary)
        Icon(Icons.Filled.Search, contentDescription = "Search", tint = MovieHubUiKitColors.TextSecondary)
        Icon(Icons.Filled.Person, contentDescription = "Profile", tint = MovieHubUiKitColors.TextSecondary)
    }
}
