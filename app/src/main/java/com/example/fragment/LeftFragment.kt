package com.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.composetutorial.databinding.LeftFragmentBinding

/**
 * Created by deqiangchen on 2024/10/12.
 */
class LeftFragment :Fragment() {

    private lateinit var leftFragmentBinding: LeftFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        leftFragmentBinding = LeftFragmentBinding.inflate(inflater,container,false)
        return leftFragmentBinding.root
    }

}