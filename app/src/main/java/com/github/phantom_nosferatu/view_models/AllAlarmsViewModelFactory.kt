package com.github.phantom_nosferatu.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.phantom_nosferatu.data.repo.AlarmRepository

class AllAlarmsViewModelFactory(private val alarmRepository: AlarmRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AllAlarmsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AllAlarmsViewModel(alarmRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}