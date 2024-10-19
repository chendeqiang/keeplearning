package com.example.kotlintest

/**
 * Created by deqiangchen on 2024/10/18.
 */

fun main() {

//    val a =10
//    val b =15
//    val c=5
    //val largest = max(a,b,c)
    //println(largest)

    val a =3.5
    val b=3.8
    val c =4.1
    val largest = max(a,b,c)
    val minest = min(a,b,c)
    println("largest is $largest")
    println("minest is $minest")

}


//fun max(vararg nums:Int):Int{
//    var maxNum = Int.MIN_VALUE
//    for (num in nums){
//        maxNum = kotlin.math.max(maxNum,num)
//    }
//    return maxNum
//}

fun <T : Comparable<T>> max(vararg nums: T): T {
    if (nums.isEmpty()) throw RuntimeException("params can not be empty")
    var maxNum = nums[0]
    for (num in nums) {
        if (num > maxNum) {
            maxNum = num
        }
    }
    return maxNum
}


fun <T:Comparable<T>> min(vararg nums:T):T{
    if (nums.isEmpty()) throw  RuntimeException("params can not be empty")
    var minNum = nums[0]
    for (num in nums){
        if (num <minNum){
            minNum =num
        }
    }
    return minNum
}











