package com.action.maincomponents.service

import android.content.Context
import android.content.Intent

fun startMusicService(context: Context, action: String) {
    val intent = Intent(context, MusicService::class.java).apply { this.action = action }
    context.startService(intent)
}
