package com.action.maincomponents.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_AIRPLANE_MODE_CHANGED) {
            val isEnabled = intent.getBooleanExtra("state", false)
            val message = if (isEnabled) "Airplane Mode ON" else "Airplane Mode OFF"
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }
}
