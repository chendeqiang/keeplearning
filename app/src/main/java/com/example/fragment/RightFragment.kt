package com.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.composetutorial.databinding.RightFragmentBinding

/**
 * Created by deqiangchen on 2024/10/12.
 */
class RightFragment :Fragment() {

    private lateinit var rightFragmentBinding: RightFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rightFragmentBinding = RightFragmentBinding.inflate(inflater,container,false)
        return rightFragmentBinding.root
    }
}