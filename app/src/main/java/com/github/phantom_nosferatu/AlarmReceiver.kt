package com.github.phantom_nosferatu

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import java.util.*

val notificationHelper = NotificationHelper()
class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(p0: Context, p1: Intent?) {
        Log.d("AlarmTesting", "Alarm Receiver ${Date()}")
        notificationHelper.createNotificationChannel(p0)
        notificationHelper.createNofication(p0)
    }

}
