package com.github.phantom_nosferatu

import android.app.Application
import com.github.phantom_nosferatu.data.db.AppDatabase
import com.github.phantom_nosferatu.data.repo.AlarmRepository

class App : Application() {

    val alarmRepository by lazy {
        AlarmRepository(AppDatabase.getInstance(this).alarmDao())
    }

    override fun onCreate() {
        super.onCreate()
        val database = AppDatabase.getInstance(this)
    }
}