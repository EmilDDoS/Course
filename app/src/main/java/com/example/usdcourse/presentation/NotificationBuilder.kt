package com.example.usdcourse.presentation

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import java.util.*

class NotificationBuilder(private val context: Context) {
    init {
        val notifyTime = createCalendarWithDate()
        val pendingIntent = createPendingIntent()

        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            notifyTime.timeInMillis,
            pendingIntent
        )
    }

    private fun createCalendarWithDate(): Calendar {
        val notifyTime: Calendar = Calendar.getInstance()

        notifyTime.time = Date()
        notifyTime.set(Calendar.HOUR_OF_DAY, 12)
        notifyTime.set(Calendar.MINUTE, 0)
        notifyTime.set(Calendar.SECOND, 0)

        if (notifyTime.timeInMillis <= System.currentTimeMillis()) {
            notifyTime.add(Calendar.DAY_OF_YEAR, 1);
        }

        return  notifyTime
    }

    private fun createPendingIntent(): PendingIntent {
        val intent = Intent(context.applicationContext, NotificationReceiver::class.java)
        return PendingIntent.getBroadcast(
            context,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
    }


}