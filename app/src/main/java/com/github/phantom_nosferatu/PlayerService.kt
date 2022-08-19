package com.github.phantom_nosferatu

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.IBinder
import android.util.Log

class PlayerService : Service() {

    var mediaPlayer : MediaPlayer? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)

        val uri = Uri.parse(intent?.extras?.getString("URI_EXTRA"))
        Log.d("AlarmTesting", "Uri is $uri")
        mediaPlayer = MediaPlayer.create(this, uri).apply {
            isLooping = true
            start()
        }
        return START_STICKY
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.stop()
        Log.d("AlarmTesting", "Service is destroy")
    }
}