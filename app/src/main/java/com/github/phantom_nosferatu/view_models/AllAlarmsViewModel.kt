package com.github.phantom_nosferatu.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.phantom_nosferatu.data.model.Alarm
import com.github.phantom_nosferatu.data.repo.AlarmRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AllAlarmsViewModel(private val alarmRepository: AlarmRepository) : ViewModel() {

    val alarmsLocal : MutableLiveData<List<Alarm>> = MutableLiveData()

    fun getAlarms() {
        viewModelScope.launch(Dispatchers.IO) {
        alarmsLocal.postValue(alarmRepository.getAlarms())
        }
    }

}