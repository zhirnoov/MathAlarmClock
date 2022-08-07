package com.github.phantom_nosferatu.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.github.phantom_nosferatu.AlarmHelper
import com.github.phantom_nosferatu.R
import com.github.phantom_nosferatu.data.model.Alarm
import com.github.phantom_nosferatu.data.repo.AlarmRepository
import com.github.phantom_nosferatu.view_models.AddAlarmViewModel
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat

class AddAlarmFragment : Fragment() {

    private lateinit var timePickerButton : Button
    private val alarmHelper = AlarmHelper()
   private val  viewmodel : AddAlarmViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_alarm, container, false)
        timePickerButton = view.findViewById(R.id.btn_timepicker)
        timePickerButton.setOnClickListener {
            val timePicker = MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .setHour(12)
                .setMinute(0)
                .setTitleText("Выберите текст")
                .build()

            timePicker.show(childFragmentManager, "timepicker")

            timePicker.addOnPositiveButtonClickListener {
                val hour = timePicker.hour
                val minute = timePicker.minute
                timePickerButton.text = "${hour.toString().padStart(2, '0')}:${minute.toString().padStart(2, '0')}"
                alarmHelper.setAlarm(requireContext(), hour, minute)
                viewmodel.saveAlarm(Alarm(id = 0, title = "тест", hour = hour, minute = minute, isActive = true))
            }
        }
        return view
    }
}