package com.example.kotlintest

/**
 * Created by deqiangchen on 2024/10/14.
 扩展函数*/
fun String.lettersCount():Int {
    var count = 0
    for (char in this) {
        if (char.isLetter()) {
            count++
        }

    }
    return count
}

operator fun String.times(n:Int) = repeat(n)