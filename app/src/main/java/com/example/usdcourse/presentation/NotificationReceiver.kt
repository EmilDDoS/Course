package com.example.usdcourse.presentation

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.usdcourse.R
import com.example.usdcourse.app.ApplicationModule
import com.example.usdcourse.di.DaggerAppComponent
import com.example.usdcourse.domain.interactor.MonthlyCourseUseCase
import com.example.usdcourse.domain.interactor.SharedPrefUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

private const val FORMAT_DATE = "dd/MM/yyyy"

class NotificationReceiver : BroadcastReceiver() {
    private val channelId = "channel_id"
    private val channelName = "Channel name"

    @Inject
    lateinit var sharedPrefUseCase: SharedPrefUseCase

    @Inject
    lateinit var monthlyCourseUseCase: MonthlyCourseUseCase

    private val format = SimpleDateFormat(FORMAT_DATE)
    private lateinit var disposable: Disposable

    override fun onReceive(context: Context, intent: Intent) {
        val application = context.applicationContext as Application
        DaggerAppComponent.builder().applicationModule(ApplicationModule(application))
            .build().inject(this)

        val savedCourse = sharedPrefUseCase.getData()

        val currentDate = Date()
        val formatCurrentDate = format.format(currentDate.time)

        disposable = monthlyCourseUseCase.execute(formatCurrentDate, formatCurrentDate)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { it ->
                val value = it[0].value.replace(",",".")
                val todayCourse = value.toFloat()

                if (todayCourse > savedCourse) {
                    showNotification(context)
                }
            }
    }

    private fun showNotification(context: Context) {

        val builder = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.drawable.ic_stat_name)
            .setContentTitle(context.getString(R.string.course_up))
            .setContentText(context.getString(R.string.got_to_buy))
            .setPriority(NotificationCompat.PRIORITY_MAX)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel(
                    channelId,
                    channelName,
                    NotificationManager.IMPORTANCE_DEFAULT
                )
            val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }

        with(NotificationManagerCompat.from(context)) {
            notify(1, builder.build())
        }

    }
}