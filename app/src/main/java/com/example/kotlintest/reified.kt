package com.example.kotlintest

import android.content.Context
import android.content.Intent

/**
 * Created by deqiangchen on 2024/10/17.
 * 泛型实化
 */
inline fun <reified T> startActivity(context: Context,block:Intent.() ->Unit){
    val intent = Intent(context,T::class.java)
    intent.block()
    context.startActivity(intent)
}