package com.example.kotlintest

/**
 * Created by deqiangchen on 2024/10/17.
 * 使用infix函数构建更可读的语法
 */
infix fun String.beginsWith(prefix:String) = startsWith(prefix)

infix fun <T> Collection<T>.has(element:T) = contains(element)
