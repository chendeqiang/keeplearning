package com.example.kotlintest

/**
 * Created by deqiangchen on 2024/10/10.
 */
class Student(name: String, age: Int) : Person(name, age), Study {
    //    init {
//        println("sno is "+sno)
//        println("grade is "+grade)
//    }
//    constructor(name: String,age: Int):this("",0,name, age){
//
//    }
//    constructor():this("",0){
//
//    }
    override fun readBooks() {
        println(name+" is reading.")
    }

//    override fun doHomework() {
//        println(name+" is doinng homework.")
//    }

}