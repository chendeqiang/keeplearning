package com.example.recyclerviewtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.composetutorial.R
import com.example.composetutorial.databinding.ActivityListviewBinding
import com.example.kotlintest.times

/**
 * Created by deqiangchen on 2024/10/11.
 */
class RecyclerviewTestActivity:AppCompatActivity() {

//    private val data = listOf("Apple","Banana","Orange","Watermelonn","Pear","Grape","Pineapple","Strawberry","Cherry","Mango",
//        "Apple","Banana","Orange","Watermelonn","Pear","Grape","Pineapple","Strawberry","Cherry","Mango")
    private val fruitList= ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityListviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initFruits()//初始化水果数据
        //val layoutManager = LinearLayoutManager(this)
        val layoutManager = StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)
        //layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding.rvFruit.layoutManager=layoutManager
        val adapter = FruitAdapter(fruitList)
        binding.rvFruit.adapter=adapter
    }

    private fun initFruits() {
        repeat(2){
            fruitList.add(Fruit(getRandomLengthString("Apple"), R.drawable.apple_pic))
            fruitList.add(Fruit(getRandomLengthString("Banana"), R.drawable.banana_pic))
            fruitList.add(Fruit(getRandomLengthString("Orange"), R.drawable.orange_pic))
            fruitList.add(Fruit(getRandomLengthString("Watermelonn"), R.drawable.watermelon_pic))
            fruitList.add(Fruit(getRandomLengthString("Pear"), R.drawable.pear_pic))
            fruitList.add(Fruit(getRandomLengthString("Grape"), R.drawable.grape_pic))
            fruitList.add(Fruit(getRandomLengthString("Pineapple"), R.drawable.pineapple_pic))
            fruitList.add(Fruit(getRandomLengthString("Strawberry"), R.drawable.strawberry_pic))
            fruitList.add(Fruit(getRandomLengthString("Cherry"), R.drawable.cherry_pic))
            fruitList.add(Fruit(getRandomLengthString("Mango"), R.drawable.mango_pic))
        }
    }
    //方便瀑布流布局查看
//    private fun getRandomLengthString(str:String):String{
//        val n = (1..20).random()
//        val builder = StringBuilder()
//        repeat(n){
//            builder.append(str)
//        }
//        return builder.toString()
//    }
    fun getRandomLengthString(str:String) =str*(1..20).random()
}