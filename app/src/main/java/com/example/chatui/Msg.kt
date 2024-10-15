package com.example.chatui

/**
 * Created by deqiangchen on 2024/10/12.
 */
class Msg(val content:String,val type:Int) {
    companion object{
        const val TYPE_RECEIVED=0
        const val TYPE_SENT=1
    }
}