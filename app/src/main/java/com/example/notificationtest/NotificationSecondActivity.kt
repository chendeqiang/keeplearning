package com.example.notificationtest

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.composetutorial.R
import com.example.composetutorial.databinding.ActivityNotificationSecondBinding

class NotificationSecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotificationSecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificationSecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}