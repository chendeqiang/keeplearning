package com.example.kotlintest

/**
 * Created by deqiangchen on 2024/10/10.
 */
open class Person(val name:String,val age:Int) {
    fun eat(){
        println(name+" is eating.He is "+age+" years old.")
    }
}