package com.action.maincomponents.ui.screen
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun AirplaneModeScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Toggle Airplane Mode to see a Toast Message.", style = MaterialTheme.typography.bodyLarge)

        Button(onClick = { navController.popBackStack() }) {
            Text("Back")
        }
    }
}

