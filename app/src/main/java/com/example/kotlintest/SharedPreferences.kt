package com.example.kotlintest

import android.content.SharedPreferences

/**
 * Created by deqiangchen on 2024/10/16.
 * 简化SharedPreferences用法
 */
fun SharedPreferences.open(block:SharedPreferences.Editor.() ->Unit){
    val editor =edit()
    editor.block()
    editor.apply()
}

