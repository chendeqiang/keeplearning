package com.example.kotlintest

/**
 * Created by deqiangchen on 2024/10/10.
 */
fun main(){
//    val student =Student("a123",5,"Jack",19)
//    student.eat()
//    val student1=Student()
    val student2= Student("Jack",19)
//    val student3=Student("a123",5,"Jack",19)
//    student2.readBooks()
//    student2.doHomework()
//    doStudy(student2)
    val cellphone1= Cellphone("Samsunng",1299.99)
    val cellphone2= Cellphone("Samsunng",1299.99)
//    println(cellphone1)
//    println("cellphone1 equals cellphone2 "+(cellphone1==cellphone2) )
//    Singleton.singletonTest()
    val list = listOf("Apple","Banana","Orange","Pear","Watermelon")
    val result = StringBuilder().apply {
        append("Start eating fruits.\n")
        for (fruit in list){
            append(fruit).append(".\n")
        }
        append("Ate all fruits.")
    }

//    val result = StringBuilder().run{
//        append("Start eating fruits.\n")
//        for (fruit in list){
//            append(fruit).append(".\n")
//        }
//        append("Ate all fruits.")
//        toString()
//    }
//    val result = with(StringBuilder()){
//        append("Start eating fruits.\n")
//        for (fruit in list){
//            append(fruit).append(".\n")
//        }
//        append("Ate all fruits.")
//        toString()
//    }
//    println(result.toString())
//    val list = mutableListOf("Apple","Banana","Orange","Pear","Grape")
//    list.add("Watermelon")
//    for (fruit in list){
//        println(fruit)
//    }
    val map = mapOf("Apple" to 1,"Banana" to 2,"Orange" to 3,"Pear" to 4,"Grape" to 5)
    for ((fruit,number) in map){
        println("fruit is "+fruit+",number is "+number)
    }
//    val maxLengthFruit= list.maxBy { it.length }
//    println("max length fruit is "+maxLengthFruit)
//    val newList = list.map { it.uppercase() }
//    val newList = list.filter { it.length <=5 }.map { it.uppercase() }
//    for (fruit in newList){
//        println(fruit)
//    }
    val anyResult = list.any { it.length<=5 }
    val allResult = list.all { it.length<=5 }
//    println("anyResult is "+anyResult +",allResult is "+allResult )
//    Thread{
//        println("thread id running")
//    }.start()
//    prinntParmams(str = "world")
    //doStudy(null)

    val count = "ABC123xyz".lettersCount()
//    println("lettersCount is $count")

    val money1 =Money(5)
    val money2 =Money(10)
    val money3= money1+money2
    val money4 = money3+20
//    println(money3.value)
    //println(money4.value)

}

fun doStudy(study: Study?) {
    study?.let {
        it.readBooks()
        it.doHomework()
    }
}

fun prinntParmams(num:Int=100,str:String){
    println("num is $num , str is $str")
}
