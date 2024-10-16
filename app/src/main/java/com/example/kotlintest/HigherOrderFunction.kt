package com.example.kotlintest

/**
 * Created by deqiangchen on 2024/10/15.
kotlin高阶函数 */

fun main(){
//    val num1=100
//    val num2 = 80
//    val result1 = num1AndNum2(num1,num2,::plus)
//    val result2  = num1AndNum2(num1,num2,::minus)
    //Lambda写法
//    val result1 = num1AndNum2(num1,num2){n1,n2 ->
//        n1+n2
//    }
//    val result2 = num1AndNum2(num1,num2){n1,n2 ->
//        n1-n2
//    }
//    println("result1 is $result1")
//    println("result2 is $result2")
//    val list = listOf("Apple","Banana","Orange","Pear","Grape")
//    val result = StringBuilder().build{
//        append("Start eating fruits.\n")
//        for (fruit in list){
//            append(fruit).append("\n")
//        }
//        append("Ate all fruits.")
//    }
//    println(result.toString())

    println("main start")
    val str =""
    printString(str){s->
        println("lambda start")
//        if (s.isEmpty()) return@printString //表示进行局部返回，不再执行Lambda表达式的剩余部分代码
        if (s.isEmpty()) return
        println(s)
        println("lambda end")
    }
    println("main end")
}

fun num1AndNum2(num1:Int,num2:Int,operation:(Int,Int) ->Int):Int{
    val result = operation(num1,num2)
    return result
}

//fun plus(num1:Int,num2: Int):Int{
//    return num1+num2
//}
//
//fun minus(num1: Int,num2: Int):Int{
//    return num1 - num2
//}

//给stringbuilder定义一个扩展函数builder，builder自动拥有Stringbuilder的上下文
fun StringBuilder.build(block:StringBuilder.() -> Unit):StringBuilder{
    block()
    return this
}

//fun printString(str:String,block:(String) ->Unit){
//    println("printString begin")
//    block(str)
//    println("printString end")
//}

//声明成内联函数
inline fun printString(str:String,block:(String) ->Unit){
    println("printString begin")
    block(str)
    println("printString end")
}


//内联函数的lambda表达式允许return，高阶函数的匿名类不允许使用return
//crossinline保证不会在内联函数的Lambda表达式使用return
inline fun runRunnable(crossinline block: () -> Unit){
    val runnable = Runnable {
        block()
    }
    runnable.run()
}