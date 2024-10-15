package com.example.recyclerviewtest

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.composetutorial.databinding.FruitItemBinding

/**
 * Created by deqiangchen on 2024/10/11.
 */
class FruitAdapter(val fruitList:List<Fruit>):RecyclerView.Adapter<FruitAdapter.ViewHolder>() {

    inner class ViewHolder(binding: FruitItemBinding):RecyclerView.ViewHolder(binding.root){
        val fruitImage:ImageView =binding.fruitImage
        val fruitNmae:TextView = binding.fruitName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding= FruitItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        val viewHolder =ViewHolder(binding)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            val fruit = fruitList[position]
            Toast.makeText(parent.context,"you clicked view ${fruit.name}",Toast.LENGTH_SHORT).show()
        }
        viewHolder.fruitImage.setOnClickListener {
            val position = viewHolder.adapterPosition
            val fruit= fruitList[position]
            Toast.makeText(parent.context,"you clicked image ${fruit.name}",Toast.LENGTH_SHORT).show()
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit =fruitList[position]
        holder.fruitImage.setImageResource(fruit.imageId)
        holder.fruitNmae.text=fruit.name
    }

    override fun getItemCount()=fruitList.size

}