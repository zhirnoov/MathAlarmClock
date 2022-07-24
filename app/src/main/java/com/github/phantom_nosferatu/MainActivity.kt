package com.github.phantom_nosferatu

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.*

lateinit var alarmManager: AlarmManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val receiver = Intent(this, AlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 0, receiver, PendingIntent.FLAG_UPDATE_CURRENT)
        val alarmButton = findViewById<Button>(R.id.btn_alarm)

        alarmButton.setOnClickListener {
            Log.d("MainActivity", "Create ${Date()}")
            alarmManager.setAlarmClock(AlarmManager.AlarmClockInfo(System.currentTimeMillis() + 10000, pendingIntent), pendingIntent)
        }
    }
}