package com.example.chatui

import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.composetutorial.databinding.MsgLeftItemBinding
import com.example.composetutorial.databinding.MsgRightItemBinding

/**
 * Created by deqiangchen on 2024/10/12.
 * kotlin密封类，关键字 sealed class
 */
sealed class MsgViewHolder(root: FrameLayout) :RecyclerView.ViewHolder(root){

    class LeftViewHolder(leftItemBinding: MsgLeftItemBinding): MsgViewHolder(leftItemBinding.root){
        val leftMsg = leftItemBinding.leftMsg
    }

    class RightViewHolder(rightItemBinding: MsgRightItemBinding): MsgViewHolder(rightItemBinding.root){
        val rightMsg = rightItemBinding.rightMsg
    }
}