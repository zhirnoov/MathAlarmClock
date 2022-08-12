package com.github.phantom_nosferatu

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class NotificationHelper {
    private val CHANNEL_ID = "101"
    private val notificationId = 101

    fun createNofication(context: Context) {
        val actionIntent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        val actionPendingIntent: PendingIntent =
            PendingIntent.getActivity(context, 0, actionIntent, 0)


        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_add_24)
            .setContentTitle("Мой будильник")
            .setContentText("Будильник сработал")
            .setPriority(NotificationCompat.PRIORITY_MAX)
            .addAction(R.drawable.ic_close_24, "Отключить", actionPendingIntent)
        with(NotificationManagerCompat.from(context)) {
            notify(notificationId, builder.build())
        }
    }

    fun createNotificationChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "name"
            val descriptionText = "description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}