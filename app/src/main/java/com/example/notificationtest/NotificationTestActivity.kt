package com.example.notificationtest

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.example.composetutorial.R
import com.example.composetutorial.databinding.ActivityNotificationTestBinding

class NotificationTestActivity : AppCompatActivity() {

    private lateinit var binding :ActivityNotificationTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityNotificationTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val channel = NotificationChannel("normal","Normal",NotificationManager.IMPORTANCE_DEFAULT)
            val channel2 = NotificationChannel("important","Important",NotificationManager.IMPORTANCE_HIGH)
            manager.createNotificationChannel(channel2)
        }
        binding.sendNotice.setOnClickListener {
            val intent = Intent(this,NotificationSecondActivity::class.java)
            val pi = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_IMMUTABLE)

            val notification = NotificationCompat.Builder(this,"important")
                .setContentTitle("This is content title")
                //.setContentText("This is content text")
                //setStyle()显示富文本
                .setStyle(NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(resources,R.drawable.big_image)))
                .setSmallIcon(R.drawable.small_icon)
                .setLargeIcon(BitmapFactory.decodeResource(resources,R.drawable.large_icon))
                .setContentIntent(pi)
                .setAutoCancel(true)//点击通知后自动取消通知，通知栏不显示该通知
                .build()
            manager.notify(1,notification)
        }
    }
}