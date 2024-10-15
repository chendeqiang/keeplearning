package com.example.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.composetutorial.databinding.ActivityNewsBinding

/**
 * Created by deqiangchen on 2024/10/12.
 * 1. Configurations for activity_main.xml must agree on the root element's ID
 * 这个问题发生在根据不同屏幕适配layout xml。这里注意，两个布局的根元素的 id 必须一致！
 * 解决这个问题的办法，就在布局外面都套一层布局
 *两个  activity_news.xml 的根元素的 id 必须一致！
 *
 * 2. activity 和 fragment之间的交互
 *
 *     1.activity 访问 fragment：
 *      通过fragment提供的 supportFragmentManager.
 *     2.fragment 访问 fragment：
 *      先获取fragment所在的activity，然后通过这个activity去访问另一个fragment.
 *
 */

class NewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}