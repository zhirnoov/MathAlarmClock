package com.github.phantom_nosferatu.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "alarms")
data class Alarm(
    @PrimaryKey
    val id: Int,
    val title: String,
    val hour: Int,
    val minute: Int,
    val isActive: Boolean
)