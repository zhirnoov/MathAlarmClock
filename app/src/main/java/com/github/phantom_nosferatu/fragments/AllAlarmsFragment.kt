package com.github.phantom_nosferatu.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.phantom_nosferatu.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AllAlarmsFragment : Fragment() {

    private lateinit var addButton : FloatingActionButton
    private lateinit var recyclerView : RecyclerView

    private var adapter : AlarmAdapter? = AlarmAdapter(emptyList())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_all_alarms, container, false)
        addButton = view.findViewById(R.id.btn_add)
        recyclerView = view.findViewById(R.id.rv_alarms)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        addButton.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_allAlarmsFragment_to_addAlarmFragment)
        }
        return view
    }
}