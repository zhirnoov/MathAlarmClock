package com.github.phantom_nosferatu.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.github.phantom_nosferatu.PlayerService
import com.github.phantom_nosferatu.R

class AlarmSolutionFragment : Fragment() {

    private lateinit var stopAudio : Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_alarm_solution, container, false)
        stopAudio = view.findViewById(R.id.btn_stopAudio)

        stopAudio.setOnClickListener {
        context?.stopService(Intent(context, PlayerService::class.java))
            Log.d("AlarmTesting", "Audio is stop")
        }

        return view

    }
}