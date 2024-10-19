package com.example.kotlintest

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * Created by deqiangchen on 2024/10/18.
 * kotlin协程
 * GlobalScope.launch:开启一个协程，创建一个协程的作用域，每次创建的都是顶层协程，不建议使用
 * runBlocking：让应用程序在协程中所有的代码执行完再结束，会挂起外部线程，不推荐项目使用
 * launch：创建多个协程，必须在协程的作用域中才能调用，无法获取执行结果
 * suspend：可以将任意函数声明成挂起函数（无法提供作用域），挂起函数之间可以相互调用
 * coroutineScope：也是一个挂起函数，特点是会继承外部协程的作用域并创建一个子协程，可以保证其作用域内的所有代码和子协程在全部执行完之前，外部协程会一直被挂起
 *coroutineScope：只会阻塞当前协程，既不影响其他协程，也不影响任何线程
 *async:创建一个协程并获取它的执行结果返回一个Deferred对象，调用Deferred的await（）方法，必须在协程作用域中调用,
 * withContext:async的简化写法,会立即执行代码块中代码，同时将外部协程挂起，代码块执行完之后，会将最后一行的执行结果作为函数的返回值返回，withContext（）函数强制要求我们指定一个线程参数
 *suspendCoroutine函数：必须在协程作用域或者挂起函数中调用，接收一个lambda参数，主要作用是将当前协程立即挂起，然后在一个普通的线程中执行lambd中的代码
 */
@OptIn(DelicateCoroutinesApi::class)
fun main() {

//    GlobalScope.launch {
//        println("codes run in coroutine scope")
//    }
//    Thread.sleep(1000)

//    runBlocking {
//        println("codes run in coroutine scope")
//        delay(1500)
//        println("codes run in coroutine scope finished")
//    }


    //    runBlocking {
//        launch {
//            println("launch1")
//            delay(1000)
//            println("launch1 finished")
//        }
//        launch {
//            println("launch2")
//            delay(1000)
//            println("launch2 finished")
//        }
//    }
//    suspend fun printDot() = coroutineScope {
//        launch {
//            println(".")
//            delay(1000)
//        }
//    }

//    val job = Job()
//    val scope = CoroutineScope(job)
//    scope.launch {
//        //
//    }
//    job.cancel()

//    runBlocking {
//        val result = async {
//            5+5
//        }.await()
//        println(result)
//    }

    runBlocking {
        val result = withContext(Dispatchers.Default){
            5+5
        }
        println(result)
    }

}