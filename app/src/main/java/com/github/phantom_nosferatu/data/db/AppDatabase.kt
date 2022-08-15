package com.github.phantom_nosferatu.data.db

import android.content.Context
import androidx.room.*
import com.github.phantom_nosferatu.data.dao.AlarmDao
import com.github.phantom_nosferatu.data.model.Alarm
import com.github.phantom_nosferatu.data.model.UriConverter

@Database(
    version = 1,
    entities = [Alarm::class]
)
@TypeConverters(UriConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun alarmDao(): AlarmDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "alarm_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}