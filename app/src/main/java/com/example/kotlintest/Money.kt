package com.example.kotlintest

/**
 * Created by deqiangchen on 2024/10/14.
运算符重载 */
class Money(val value:Int){

    operator fun plus(money: Money):Money{
        val sum = value+money.value
        return Money(sum)
    }

    operator fun plus(newValue:Int):Money{
        val sum=value+newValue
        return Money(sum)
    }
}