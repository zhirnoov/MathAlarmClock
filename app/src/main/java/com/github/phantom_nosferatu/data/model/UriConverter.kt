package com.github.phantom_nosferatu.data.model

import android.net.Uri
import androidx.room.TypeConverter

class UriConverter {

    @TypeConverter
    fun fromString(value: String): Uri? {
        return if (value == null) null else Uri.parse(value)
    }

    @TypeConverter
    fun toString(uri: Uri): String {
        return uri?.toString()
    }
}
