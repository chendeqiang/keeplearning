package com.example.servicetest

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.composetutorial.databinding.ActivityMyServiceBinding

class MyServiceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyServiceBinding
    lateinit var downloadBinder:MyService.DownloadBinder
    private val connection= object :ServiceConnection{
        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            downloadBinder = service as MyService.DownloadBinder
            downloadBinder.startDownload()
            downloadBinder.getProgress()
        }

        override fun onServiceDisconnected(name: ComponentName) {
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMyServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startServiceBtn.setOnClickListener {
            val intent = Intent(this,MyService::class.java)
            startService(intent)
        }

        binding.stopServiceBtn.setOnClickListener {
            val intent = Intent(this,MyService::class.java)
            stopService(intent)
        }

        binding.bindServiceBtn.setOnClickListener {
            val intent = Intent(this,MyService::class.java)
            bindService(intent,connection, Context.BIND_AUTO_CREATE)
        }

        binding.unbindServiceBtn.setOnClickListener {
            unbindService(connection)
        }

        binding.startIntentServiceBtn.setOnClickListener {
            //打印主线程id
            Log.d("MyServiceActivity","Thread id is ${Thread.currentThread().name}")
            val intent = Intent(this,MyIntentService::class.java)
            startService(intent)
        }
    }
}