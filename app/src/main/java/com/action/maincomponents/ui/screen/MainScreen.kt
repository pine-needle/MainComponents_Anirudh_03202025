package com.action.maincomponents.ui.screen

import android.app.Activity
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation

@Composable
fun MainScreen(activity: Activity, navController: NavController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { navController.navigate("music_player_screen") }) {
            Text("Music Player")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate("contacts_screen") }) {
            Text("Contacts")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate("airplane_mode_screen") }) {
            Text("Airplane Mode")
        }
    }
}


@Composable
fun MainActivityScreen(activity: Activity) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main_screen") {
        composable("main_screen") { MainScreen(activity, navController) }
        composable("music_player_screen") { MusicPlayerScreen(navController) }
        composable("contacts_screen") { ContactsScreen(activity, navController) }
        composable("airplane_mode_screen") { AirplaneModeScreen(navController) }
    }
}



