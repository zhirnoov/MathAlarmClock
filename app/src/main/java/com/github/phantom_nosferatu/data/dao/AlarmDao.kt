package com.github.phantom_nosferatu.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.github.phantom_nosferatu.data.model.Alarm

@Dao
interface AlarmDao {

    @Insert
    suspend fun saveAlarm(alarm: Alarm)

    @Query("SELECT * FROM alarms")
    suspend fun getAlarms(): List<Alarm>

}
