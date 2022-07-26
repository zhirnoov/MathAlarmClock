package com.github.phantom_nosferatu.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.phantom_nosferatu.R
import com.github.phantom_nosferatu.data.model.Alarm
import com.google.android.material.switchmaterial.SwitchMaterial

class AlarmAdapter(private val alarms: List<Alarm>) :
    RecyclerView.Adapter<AlarmAdapter.AlarmViewHolder>() {


    inner class AlarmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title: TextView = itemView.findViewById(R.id.tv_title)
        val time: TextView = itemView.findViewById(R.id.tv_time)
        val switch: SwitchMaterial = itemView.findViewById(R.id.btn_switch)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.alarm_row_item, parent, false)
        return AlarmViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlarmViewHolder, position: Int) {
        val alarm = alarms[position]
        holder.title.text = alarm.title
        holder.time.text =
            "${alarm.hour.toString().padStart(2, '0')}:${alarm.minute.toString().padStart(2, '0')}"
        holder.switch.isChecked
    }

    override fun getItemCount() = alarms.size

}
