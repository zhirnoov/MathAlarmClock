package com.github.phantom_nosferatu.fragments

import android.Manifest
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.NumberPicker
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts.RequestPermission
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.github.phantom_nosferatu.AlarmHelper
import com.github.phantom_nosferatu.App
import com.github.phantom_nosferatu.R
import com.github.phantom_nosferatu.data.model.Alarm
import com.github.phantom_nosferatu.view_models.AddAlarmViewModel
import com.github.phantom_nosferatu.view_models.AddAlarmViewModelFactory
import java.util.*

class AddAlarmFragment : Fragment() {

    private lateinit var hourPicker: NumberPicker
    private lateinit var minutePicker: NumberPicker
    private lateinit var saveButton: Button
    private lateinit var titleField: EditText
    private lateinit var chooseSoundButton: Button
    private val alarmHelper = AlarmHelper()
    private val viewModel: AddAlarmViewModel by viewModels {
        AddAlarmViewModelFactory(App().alarmRepository)
    }
    private var hour: Int = 0
    private var minute: Int = 0

    private val readStoragePermissionLauncher = registerForActivityResult(
        RequestPermission(),
        ::getStoragePermission
    )

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_alarm, container, false)
        hourPicker = view.findViewById(R.id.picker_hour)
        minutePicker = view.findViewById(R.id.picker_minute)
        saveButton = view.findViewById(R.id.btn_save)
        titleField = view.findViewById(R.id.et_title)
        chooseSoundButton = view.findViewById(R.id.btn_chooseSound)

        if (savedInstanceState != null) {
            hour = savedInstanceState.getInt("INT_HOUR", hour)
            minute = savedInstanceState.getInt("INT_MINUTE", minute)

        }

        setupTimePicker(hourPicker, minutePicker)

        hourPicker.setOnValueChangedListener { numberPicker, i, i2 ->
            hour = hourPicker.value
        }

        minutePicker.setOnValueChangedListener { numberPicker, i, i2 ->
            minute = minutePicker.value
        }

        chooseSoundButton.setOnClickListener {
            readStoragePermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
        }

        saveButton.setOnClickListener {
            alarmHelper.setAlarm(requireContext(), hour, minute)
            viewModel.saveAlarm(
                Alarm(
                    id = 0,
                    title = titleField.text.toString(),
                    hour = hour,
                    minute = minute,
                    isActive = true
                )
            )
            Log.d("AlarmTesting", "Alarm init ${Date()}")
            Toast.makeText(context, "Alarm $hour:$minute create", Toast.LENGTH_SHORT).show()
            findNavController().popBackStack()
        }
        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("INT_HOUR", hour)
        outState.putInt("INT_MINUTE", minute)
    }
}

private fun setupTimePicker(hourPicker: NumberPicker, minutePicker: NumberPicker) {

    hourPicker.minValue = 0
    hourPicker.maxValue = 23
    hourPicker.setFormatter {
        String.format("%02d", it)
    }
    hourPicker.wrapSelectorWheel = true

    minutePicker.minValue = 0
    minutePicker.maxValue = 59
    minutePicker.setFormatter {
        String.format("%02d", it)
    }
}

private fun getStoragePermission(granted: Boolean) {
    if (granted) {
        Log.d("AlarmTesting", "Permission is granted!")
    } else {
        Log.d("AlarmTesting", "Permission is denied")
    }

}