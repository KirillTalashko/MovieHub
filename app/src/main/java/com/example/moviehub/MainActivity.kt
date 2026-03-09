package com.example.moviehub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.main.ui.MainHomeScreen
import com.example.moviehub.ui.theme.MovieHubTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieHubTheme(
                darkTheme = true,
                dynamicColor = false
            ) {
                MainHomeScreen()
            }
        }
    }
}
