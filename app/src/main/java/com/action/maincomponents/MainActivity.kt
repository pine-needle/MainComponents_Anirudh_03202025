package com.action.maincomponents

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.action.maincomponents.receiver.AirplaneModeReceiver
import com.action.maincomponents.ui.screen.AirplaneModeScreen
import com.action.maincomponents.ui.screen.ContactsScreen
import com.action.maincomponents.ui.screen.MainActivityScreen
import com.action.maincomponents.ui.screen.MainScreen
import com.action.maincomponents.ui.screen.MusicPlayerScreen
import com.action.maincomponents.ui.theme.MainComponentsTheme

class MainActivity : ComponentActivity() {
    private val airplaneReceiver = AirplaneModeReceiver()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Register BroadcastReceiver

        registerReceiver(airplaneReceiver, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED))
        enableEdgeToEdge()
        setContent {
            MainComponentsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainActivityScreen(activity = this)
                    //MusicPlayerScreen()
                    //ContactsScreen(this)
                    //AirplaneModeScreen()
                }
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(airplaneReceiver) // Unregister to avoid memory leaks
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MainComponentsTheme {
        Greeting("Android")
    }
}