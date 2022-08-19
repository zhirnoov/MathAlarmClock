package com.github.phantom_nosferatu

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
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

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onReceive(context: Context, intent: Intent?) {
        Log.d("AlarmTesting", "Alarm Receiver ${Date()}")
        val notificationHelper = NotificationHelper()
        notificationHelper.createNotificationChannel(context)
        notificationHelper.createNofication(context)

        scope.launch(Dispatchers.IO) {
            uri = App().alarmRepository.getAlarms().map { it.soundUri }.first()!!
            Log.d("AlarmTesting", "Uri in receiver is $uri")
            val intentService = Intent(context, PlayerService::class.java).putExtra("URI_EXTRA", uri.toString())
            context.startService(intentService)
        }
    }
}
