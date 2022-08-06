package com.github.phantom_nosferatu.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.github.phantom_nosferatu.data.dao.AlarmDao
import com.github.phantom_nosferatu.data.model.Alarm

@Database(
    version = 1,
    entities = [Alarm::class]
)
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
                    "alarm-db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}