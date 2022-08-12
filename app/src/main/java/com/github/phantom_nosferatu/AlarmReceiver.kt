package com.github.phantom_nosferatu

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.media.RingtoneManager
import android.util.Log
import java.util.*

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(p0: Context, p1: Intent?) {
        Log.d("AlarmTesting", "Alarm Receiver ${Date()}")
        val notificationHelper = NotificationHelper()
        notificationHelper.createNotificationChannel(p0)
        notificationHelper.createNofication(p0)
        val mediaPlayer = MediaPlayer.create(p0, R.raw.alarm_sound)
        mediaPlayer.start()
    }
}
