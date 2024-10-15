package com.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.composetutorial.R
import com.example.composetutorial.databinding.NewsItemBinding
import com.example.composetutorial.databinding.NewsTitleFragBinding

/**
 * Created by deqiangchen on 2024/10/12.
 */
class NewsTitleFragment :Fragment(){

    private var isTwoPane = false
    private lateinit var binding: NewsTitleFragBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        isTwoPane = activity?.findViewById<View>(R.id.newsContentLayout) !=null
        binding = NewsTitleFragBinding.inflate(inflater,container,false)
        val layoutManager = LinearLayoutManager(activity)
        binding.newsTitleRecyclerView.layoutManager =layoutManager
        val adapter = NewsAdapter(getNews())
        binding.newsTitleRecyclerView.adapter=adapter
        return binding.root
    }
    private fun getNews(): List<News> {
        val newsList = ArrayList<News>()
        for (i in 1 .. 50){
            val news = News("This is news title $i",getRandomLengthString("This is newscontent $i."))
            newsList.add(news)
        }
        return newsList
    }

    private fun getRandomLengthString(str: String): String {
        val n = (1..20).random()
        val builder = StringBuilder()
        repeat(n){
            builder.append(str)
        }
        return builder.toString()
    }

    inner class  NewsAdapter(val newsList:List<News>):RecyclerView.Adapter<NewsAdapter.ViewHolder>(){

        inner class ViewHolder(binding: NewsItemBinding):RecyclerView.ViewHolder(binding.root){
            val newsTitle :TextView = binding.newsTitle
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding = NewsItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            val viewHolder = ViewHolder(binding)
            viewHolder.itemView.setOnClickListener {
                val news = newsList[viewHolder.adapterPosition]
                if (isTwoPane){
                    // 如果是双页模式，刷新NewsContentFragment
                    //fragment 访问 fragment：先获取fragment所在的activity，然后通过这个activity去访问另一个fragment.
                    val activity = activity as NewsActivity
                    val fragment =activity.supportFragmentManager.findFragmentById(R.id.newsContentFrag) as NewsContentFragment
                    fragment.refresh(news.title,news.content)
                }else{
                    //如果是单页，直接启动NewsContentActivity
                    NewsContentActivity.actionStart(parent.context, news.title, news.content)
                }
            }
            return viewHolder
        }

        override fun getItemCount() = newsList.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val news = newsList[position]
            holder.newsTitle.text = news.title
        }
    }
}