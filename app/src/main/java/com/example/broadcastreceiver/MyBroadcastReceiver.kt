package com.example.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

/**
 * Created by deqiangchen on 2024/10/14.
发送自定义(标准)广播 */

class MyBroadcastReceiver:BroadcastReceiver(){

    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context,"received in MyBroadcastReceiver",Toast.LENGTH_SHORT).show()

        abortBroadcast()//截断广播
    }

}