package org.stormlightlabs.thoughtstack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import org.stormlightlabs.thoughtstack.ui.DeckListScreen
import org.stormlightlabs.thoughtstack.ui.theme.ThoughtStackTheme


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ThoughtStackTheme {
                DeckListScreen()
            }
        }
    }
}