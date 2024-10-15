package com.example.chatui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.composetutorial.databinding.MsgLeftItemBinding
import com.example.composetutorial.databinding.MsgRightItemBinding

/**
 * Created by deqiangchen on 2024/10/12.
 */
class MsgAdapter(val msgList:List<Msg>):RecyclerView.Adapter<MsgViewHolder>() {
//      使用密封类sealed class 优化代码
//    inner class LeftViewHolder(leftItemBinding: MsgLeftItemBinding):RecyclerView.ViewHolder(leftItemBinding.root){
//        val leftMsg:TextView = leftItemBinding.leftMsg
//    }
//
//    inner class RightViewHolder(rightItemBinding: MsgRightItemBinding):RecyclerView.ViewHolder(rightItemBinding.root){
//        val rightMsg :TextView = rightItemBinding.rightMsg
//    }

    override fun getItemViewType(position: Int): Int {
        val msg = msgList[position]
        return msg.type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = if (viewType== Msg.TYPE_RECEIVED){
        val leftItemBinding = MsgLeftItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        MsgViewHolder.LeftViewHolder(leftItemBinding)
    }else{
        val rightItemBinding = MsgRightItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        MsgViewHolder.RightViewHolder(rightItemBinding)
    }

    override fun getItemCount() = msgList.size

    override fun onBindViewHolder(holder: MsgViewHolder, position: Int) {
        val msg= msgList[position]
        when(holder){
            is MsgViewHolder.LeftViewHolder -> holder.leftMsg.text = msg.content
            is MsgViewHolder.RightViewHolder ->holder.rightMsg.text= msg.content
            //      使用密封类sealed class 优化代码
            //else ->throw IllegalArgumentException()
        }
    }
}