package com.github.phantom_nosferatu

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

lateinit var alarmManager : AlarmManager
lateinit var pendingIntent : PendingIntent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager


    }
}