package com.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.composetutorial.databinding.NewsContentFragBinding

/**
 * Created by deqiangchen on 2024/10/12.
 */
class NewsContentFragment:Fragment() {


    private lateinit var binding: NewsContentFragBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = NewsContentFragBinding.inflate(inflater,container,false)
        return binding.root
    }

    fun refresh(title:String,content:String){
        binding.contentLayout.visibility = View.VISIBLE
        binding.newsTitle.text= title
        binding.newsContent.text =content
    }
}