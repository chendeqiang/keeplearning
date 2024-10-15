package com.example.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.broadcastreceiver.broadcastbestpractice.BaseActivity
import com.example.composetutorial.R
import com.example.composetutorial.databinding.ActivityBroadcastReceiverBinding

class BroadcastReceiverActivity : BaseActivity() {

    private lateinit var binding: ActivityBroadcastReceiverBinding
    lateinit var timeChangerReceiver: TimeChangerReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBroadcastReceiverBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intentFilter =IntentFilter()
        intentFilter.addAction("android.intent.action.TIME_TICK")
        timeChangerReceiver =TimeChangerReceiver()
        registerReceiver(timeChangerReceiver,intentFilter)

        binding.button.setOnClickListener {
            val intent = Intent("com.example.broadcastreceiver.MY_BROADCAST")
            intent.setPackage(packageName)
            //sendBroadcast(intent)
            sendOrderedBroadcast(intent,null)
        }

        binding.forceOffline.setOnClickListener {
            val  intent = Intent("com.example.broadcastreceiver.FORCE_OFFLINE")
            sendBroadcast(intent)
        }
    }

    inner class TimeChangerReceiver:BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            Toast.makeText(context,"Time has changed",Toast.LENGTH_SHORT).show()
        }

    }
    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(timeChangerReceiver)
    }
}