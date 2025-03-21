package com.action.maincomponents.service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import com.action.maincomponents.R

class MusicService : Service() {
    private var mediaPlayer: MediaPlayer? = null
    private var currentTrackIndex = 0
    private val trackList = listOf(
        R.raw.so_fresh, // Add your songs in res/raw/
        R.raw.senorita,
        R.raw.cool_as_cucum
    )

    override fun onCreate() {
        super.onCreate()
        // Initialize MediaPlayer on Service creation
        mediaPlayer = MediaPlayer.create(this, trackList[currentTrackIndex])
        mediaPlayer?.setOnCompletionListener { nextTrack() }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            "PLAY" -> playMusic()
            "PAUSE" -> pauseMusic()
            "NEXT" -> nextTrack()
            "PREVIOUS" -> previousTrack()
            "STOP" -> stopMusic()
        }
        return START_STICKY
    }

    private fun playMusic() {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, trackList[currentTrackIndex])
            mediaPlayer?.setOnCompletionListener { nextTrack() }
        }
        mediaPlayer?.start()
    }

    private fun pauseMusic() {
        mediaPlayer?.pause()
    }

    private fun stopMusic() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }

    private fun nextTrack() {
        stopMusic()
        currentTrackIndex = (currentTrackIndex + 1) % trackList.size
        playMusic()
    }

    private fun previousTrack() {
        stopMusic()
        currentTrackIndex = if (currentTrackIndex - 1 < 0) trackList.size - 1 else currentTrackIndex - 1
        playMusic()
    }

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onDestroy() {
        super.onDestroy()
        stopMusic()
    }
}
