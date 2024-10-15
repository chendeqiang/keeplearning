package com.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.composetutorial.databinding.AnotherRightFragmentBinding

/**
 * Created by deqiangchen on 2024/10/12.
 */
class AnotherRightFragmnet :Fragment() {

    private lateinit var anotherRightFragmentBinding: AnotherRightFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        anotherRightFragmentBinding =AnotherRightFragmentBinding.inflate(inflater,container,false)
        return anotherRightFragmentBinding.root
    }
}