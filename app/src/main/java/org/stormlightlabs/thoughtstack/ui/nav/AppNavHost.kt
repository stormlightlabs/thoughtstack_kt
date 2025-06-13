package org.stormlightlabs.thoughtstack.ui.nav


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import org.stormlightlabs.thoughtstack.ui.screens.DeckListScreen
import org.stormlightlabs.thoughtstack.ui.screens.HomeScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "home") {
        composable("home") {
            HomeScreen(onDeckClick = { navController.navigate("deck/$it") })
        }
        composable("deck/{deckId}") { backStackEntry ->
            DeckListScreen(
                deckId = backStackEntry.arguments!!.getString("deckId")!!,
                onBack = { navController.popBackStack() })
        }
    }
}