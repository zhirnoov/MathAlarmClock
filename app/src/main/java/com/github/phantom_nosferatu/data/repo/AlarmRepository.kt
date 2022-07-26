package com.github.phantom_nosferatu.data.repo

import com.github.phantom_nosferatu.data.dao.AlarmDao
import com.github.phantom_nosferatu.data.model.Alarm
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AlarmRepository(private val alarmDao: AlarmDao) {

    suspend fun saveAlarm(alarm: Alarm) {
            alarmDao.saveAlarm(alarm)
    }

    suspend fun getAlarms(): List<Alarm> {
        return alarmDao.getAlarms()
    }
}