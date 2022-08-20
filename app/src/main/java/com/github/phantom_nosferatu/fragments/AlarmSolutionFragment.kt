package com.github.phantom_nosferatu.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.github.phantom_nosferatu.PlayerService
import com.github.phantom_nosferatu.R
import kotlin.properties.Delegates
import kotlin.random.Random
import kotlin.random.nextInt

class AlarmSolutionFragment : Fragment() {

    private lateinit var stopAudio : Button
    private lateinit var questionText : TextView
    private lateinit var answerEditText : EditText
    private var randomValueOne by Delegates.notNull<Int>()
    private var randomValueTwo by Delegates.notNull<Int>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_alarm_solution, container, false)
        stopAudio = view.findViewById(R.id.btn_stopAudio)
        questionText = view.findViewById(R.id.text_question)
        answerEditText = view.findViewById(R.id.et_answer)
        if (savedInstanceState != null) {
            randomValueOne = savedInstanceState.getInt("RANDOM_VALUE_ONE")
            randomValueTwo = savedInstanceState.getInt("RANDOM_VALUE_TWO")
        } else {
            val random = Random(System.currentTimeMillis())
            randomValueOne = random.nextInt(10,90)
            randomValueTwo = random.nextInt(10, 90)

        }

        questionText.text = "$randomValueOne + $randomValueTwo"

        stopAudio.setOnClickListener {
            if (Integer.parseInt(answerEditText.text.toString()) == randomValueOne+randomValueTwo) {
                context?.stopService(Intent(context, PlayerService::class.java))
                Log.d("AlarmTesting", "Audio is stop")
            } else {
                Log.d("AlarmTesting", "Try again!")
            }
        }

        return view

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("RANDOM_VALUE_ONE", randomValueOne )
        outState.putInt("RANDOM_VALUE_TWO", randomValueTwo)
    }
}