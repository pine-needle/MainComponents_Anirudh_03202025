package com.action.maincomponents.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import com.action.maincomponents.data.Contact
import com.google.gson.Gson

class ContactsStorage(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("contacts_prefs", Context.MODE_PRIVATE)

    fun saveContacts(contacts: List<Contact>) {
        prefs.edit().putString("contacts", Gson().toJson(contacts)).apply()
    }

    fun getSavedContacts(): List<Contact> {
        val json = prefs.getString("contacts", "[]") ?: "[]"
        return Gson().fromJson(json, Array<Contact>::class.java).toList()
    }
}

