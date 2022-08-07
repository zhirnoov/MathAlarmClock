package com.github.phantom_nosferatu.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.phantom_nosferatu.data.model.Alarm
import com.github.phantom_nosferatu.data.repo.AlarmRepository
import kotlinx.coroutines.launch

class AddAlarmViewModel(private val alarmRepository: AlarmRepository) : ViewModel() {

    fun saveAlarm(alarm: Alarm) {
        viewModelScope.launch {
            alarmRepository.saveAlarm(alarm)
        }
    }
}