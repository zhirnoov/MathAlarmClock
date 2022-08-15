package com.github.phantom_nosferatu

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.media.RingtoneManager
import android.net.Uri
import android.util.Log
import com.github.phantom_nosferatu.data.dao.AlarmDao
import com.github.phantom_nosferatu.data.repo.AlarmRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.util.*

class AlarmReceiver : BroadcastReceiver() {

    private val scope = CoroutineScope(SupervisorJob())
    private lateinit var uri: Uri

    override fun onReceive(p0: Context, p1: Intent?) {
        Log.d("AlarmTesting", "Alarm Receiver ${Date()}")
        val notificationHelper = NotificationHelper()
        notificationHelper.createNotificationChannel(p0)
        notificationHelper.createNofication(p0)

        scope.launch(Dispatchers.IO) {
            uri = App().alarmRepository.getAlarms().map { it.soundUri }.first()!!
            val mediaPlayer = MediaPlayer.create(p0, uri)
            mediaPlayer.start()
        }
    }
}
