package com.github.phantom_nosferatu.data.model

data class Alarm(
    val id: Int,
    val title: String,
    val hour: Int,
    val minute: Int,
    val isActive: Boolean
)