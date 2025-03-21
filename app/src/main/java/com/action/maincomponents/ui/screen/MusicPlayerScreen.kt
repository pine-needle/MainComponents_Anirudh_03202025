package com.action.maincomponents.ui.screen

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import com.action.maincomponents.service.startMusicService
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun MusicPlayerScreen(navController: NavController) {
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { startMusicService(context, "PLAY") }) {
            Text("Play")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { startMusicService(context, "PAUSE") }) {
            Text("Pause")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { startMusicService(context, "PREVIOUS") }) {
            Text("Previous")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { startMusicService(context, "NEXT") }) {
            Text("Next")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { startMusicService(context, "STOP") }) {
            Text("Stop")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { navController.popBackStack() }) {
            Text("Back")
        }
    }
}
