package com.github.phantom_nosferatu.data.model

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "alarms")
data class Alarm(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val hour: Int,
    val minute: Int,
    val soundUri: Uri?,
    val isActive: Boolean
)