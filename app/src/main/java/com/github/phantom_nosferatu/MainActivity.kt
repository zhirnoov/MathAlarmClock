package com.github.phantom_nosferatu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment

// lateinit var alarmManager: AlarmManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController


     /*   alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val receiver = Intent(this, AlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 0, receiver, PendingIntent.FLAG_UPDATE_CURRENT)
        val alarmButton = findViewById<Button>(R.id.btn_alarm)

        alarmButton.setOnClickListener {
            Log.d("MainActivity", "Create ${Date()}")
            alarmManager.setAlarmClock(AlarmManager.AlarmClockInfo(System.currentTimeMillis() + 10000, pendingIntent), pendingIntent)
        } */
    }

    override fun onSupportNavigateUp(): Boolean {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        return navController.navigateUp()
    }
}