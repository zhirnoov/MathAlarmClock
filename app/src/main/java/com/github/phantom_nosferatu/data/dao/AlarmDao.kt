package com.github.phantom_nosferatu.data.dao

import androidx.annotation.Nullable
import androidx.room.*
import com.github.phantom_nosferatu.data.model.Alarm

@Dao
interface AlarmDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAlarm(alarm: Alarm)

    @Query("SELECT * FROM alarms")
    suspend fun getAlarms(): List<Alarm>

}
