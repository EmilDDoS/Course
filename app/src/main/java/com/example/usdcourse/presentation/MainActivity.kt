package com.example.usdcourse.presentation

import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.usdcourse.databinding.ActivityMainBinding
import com.example.usdcourse.presentation.screens.coursescreen.CourseFragment
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val courseFragment = CourseFragment()
        supportFragmentManager.beginTransaction()
            .add(binding.container.id, courseFragment)
            .commit()

        createAlarm()
    }

    private fun createAlarm() {

        val notifyTime: Calendar = Calendar.getInstance()
        notifyTime.time = Date()
        notifyTime.set(Calendar.HOUR_OF_DAY, 13)
        notifyTime.set(Calendar.MINUTE, 59)
        notifyTime.set(Calendar.SECOND, 0)

        val intent = Intent(applicationContext, NotificationReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            this,
            0,
            intent,
            PendingIntent.FLAG_IMMUTABLE
        )

        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,
            notifyTime.timeInMillis,
            AlarmManager.INTERVAL_DAY,
            pendingIntent
        )

    }

}
