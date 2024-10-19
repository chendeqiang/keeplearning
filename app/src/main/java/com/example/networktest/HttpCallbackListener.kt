package com.example.networktest

/**
 * Created by deqiangchen on 2024/10/18.
 */
interface HttpCallbackListener {

    fun onFinish(response:String)
    fun onError(e:Exception)
}