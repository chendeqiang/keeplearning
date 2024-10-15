package com.example.broadcastreceiver.broadcastbestpractice

import android.app.Activity

/**
 * Created by deqiangchen on 2024/10/14.
管理所有的activity */
object ActivityCollector {

    private val activities = ArrayList<Activity>()

    fun addActivity(activity: Activity){
        activities.add(activity)
    }

    fun removeActivity(activity: Activity){
        activities.remove(activity)
    }

    fun finishAll(){
        for (activity in activities){
            if (!activity.isFinishing){
                activity.finish()
            }
        }
        activities.clear()
    }
}