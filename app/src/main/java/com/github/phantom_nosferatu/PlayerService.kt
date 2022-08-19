package com.github.phantom_nosferatu

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.IBinder
import android.util.Log

class PlayerService : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)

        val uri = Uri.parse(intent?.extras?.getString("URI_EXTRA"))
        Log.d("AlarmTesting", "Uri is $uri")
        val mediaPlayer = MediaPlayer.create(this, uri)
        mediaPlayer.isLooping = true
        mediaPlayer.start()
        return START_STICKY
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}