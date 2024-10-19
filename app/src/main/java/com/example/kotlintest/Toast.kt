package com.example.kotlintest

import android.content.Context
import android.widget.Toast

/**
 * Created by deqiangchen on 2024/10/19.
 */

fun String.showToast(context: Context,duration:Int=Toast.LENGTH_SHORT){
    Toast.makeText(context,this,duration).show()
}

fun Int.showToast(context: Context,duration:Int=Toast.LENGTH_SHORT){
    Toast.makeText(context,this,duration).show()
}