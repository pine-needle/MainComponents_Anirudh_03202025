package com.action.maincomponents.ui.screen

import android.app.Activity
import android.content.Context
import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.action.maincomponents.data.Contact
import com.action.maincomponents.sharedpreferences.ContactsStorage
import com.action.maincomponents.sharedpreferences.getContacts
import com.action.maincomponents.sharedpreferences.requestContactsPermission

@Composable
fun ContactsScreen(activity: Activity, navController: NavController) {
    val context = LocalContext.current
    val contactsStorage = remember { ContactsStorage(context) }
    var contacts by remember { mutableStateOf(emptyList<Contact>()) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            requestContactsPermission(activity)
        }) {
            Text("Request Permission")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            Handler(Looper.getMainLooper()).post {
                contacts = getContacts(context)
                contactsStorage.saveContacts(contacts)
            }
        }) {
            Text("Load Contacts")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            contacts = contactsStorage.getSavedContacts()
        }) {
            Text("Load from SharedPreferences")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(contacts) { contact ->
                Text(text = "${contact.name} - ${contact.phoneNumber}", modifier = Modifier.padding(8.dp))
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("main_screen") }) {
            Text("Home")
        }
    }
}