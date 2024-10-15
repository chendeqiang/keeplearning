package com.example.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.composetutorial.R
import com.example.composetutorial.databinding.ActivityNewsContentBinding

class NewsContentActivity : AppCompatActivity() {

    companion object{
        fun actionStart(context: Context,title:String,content:String){
            val intent = Intent(context, NewsContentActivity::class.java).apply {
                putExtra("news_title",title)
                putExtra("news_content",content)
            }
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNewsContentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val title = intent.getStringExtra("news_title")
        val content = intent.getStringExtra("news_content")
        if (title!=null&&content!=null){
            val fragmnet = supportFragmentManager.findFragmentById(R.id.newsContentFrag) as NewsContentFragment
            fragmnet.refresh(title,content)
        }
    }
}