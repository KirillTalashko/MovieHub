package com.example.main.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.magnifier
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.kit.MovieHubAvatar
import com.example.ui.kit.MovieHubBottomBar
import com.example.ui.kit.MovieHubFilterChip
import com.example.ui.kit.MovieHubPosterCard
import com.example.ui.kit.MovieHubSearchField
import com.example.ui.kit.MovieHubUiKitColors

private data class MainPosterUi(
    val id: String,
    val title: String,
    val subtitle: String,
    val rating: Float,
    val startColor: Color,
    val endColor: Color
)

@Composable
fun MainHomeScreen(modifier: Modifier = Modifier) {
    var query by remember { mutableStateOf("") }
    var selectedFilter by remember { mutableStateOf("Genre") }

    val filters = remember {
        listOf("Genre", "Top IMDb", "Search", "Profile")
    }

    val posters = remember {
        listOf(
            MainPosterUi(
                id = "money-heist",
                title = "Money Heist",
                subtitle = "2021 | Action",
                rating = 4.7f,
                startColor = Color(0xFF8D0E16),
                endColor = Color(0xFF121219)
            ), MainPosterUi(
                id = "sandman",
                title = "The Sandman",
                subtitle = "2022 | Fantasy",
                rating = 4.5f,
                startColor = Color(0xFF1A314B),
                endColor = Color(0xFF101219)
            ), MainPosterUi(
                id = "witcher",
                title = "The Witcher",
                subtitle = "2023 | Adventure",
                rating = 4.4f,
                startColor = Color(0xFF3A261E),
                endColor = Color(0xFF111111)
            )
        )
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MovieHubUiKitColors.AppBackground)
            .padding(horizontal = 16.dp)
            .padding(top = 40.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Hello Daizy!",
                        color = MovieHubUiKitColors.TextPrimary,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Check for latest addition.",
                        color = MovieHubUiKitColors.TextSecondary,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                MovieHubAvatar(onClick = {})
            }

            Spacer(modifier = Modifier.height(18.dp))
            MovieHubSearchField(
                query = query, onQueryChange = { query = it })

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Filters",
                color = MovieHubUiKitColors.TextPrimary,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(10.dp))

            LazyRow(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
                items(filters) { filter ->
                    MovieHubFilterChip(
                        title = filter,
                        selected = filter == selectedFilter,
                        onClick = { selectedFilter = filter })
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Featured Series",
                color = MovieHubUiKitColors.TextPrimary,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(10.dp))

            LazyRow(
                Modifier.fillMaxHeight()
                .weight(1f)
                ,horizontalArrangement = Arrangement.spacedBy(30.dp)) {
                items(posters, key = { it.id }) { item ->
                    MovieHubPosterCard(
                        title = item.title,
                        subtitle = item.subtitle,
                        rating = item.rating,
                        startColor = item.startColor,
                        endColor = item.endColor,
                        onClick = {})
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            MovieHubBottomBar()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MainHomeScreenPreview() {
    MainHomeScreen()
}
