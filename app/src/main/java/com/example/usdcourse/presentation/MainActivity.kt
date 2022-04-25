package com.example.usdcourse.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.usdcourse.databinding.ActivityMainBinding
import com.example.usdcourse.presentation.screens.coursescreen.CourseFragment


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

        NotificationBuilder(this)
    }

}
