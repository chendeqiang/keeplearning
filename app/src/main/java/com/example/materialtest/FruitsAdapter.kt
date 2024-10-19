package com.example.materialtest

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.composetutorial.databinding.FruitsItemBinding

/**
 * Created by deqiangchen on 2024/10/18.
 */
class FruitsAdapter(val context: Context, val fruitList:List<Fruits>) :RecyclerView.Adapter<FruitsAdapter.ViewHolder>(){

    inner class ViewHolder(binding: FruitsItemBinding):RecyclerView.ViewHolder(binding.root){
        val fruitImage:ImageView =binding.fruitImage
        val fruitName :TextView =binding.fruitName
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitsAdapter.ViewHolder {
        val binding = FruitsItemBinding.inflate(LayoutInflater.from(context),parent,false)
        val viewHolder = ViewHolder(binding)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            val fruit = fruitList[position]
            val intent = Intent(context,FruitInfoActivity::class.java).apply {
                putExtra(FruitInfoActivity.FRUIT_NAME,fruit.name)
                putExtra(FruitInfoActivity.FRUIT_IMAGE_ID,fruit.imageId)
            }
            context.startActivity(intent)
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: FruitsAdapter.ViewHolder, position: Int) {
        val fruit = fruitList[position]
        holder.fruitName.setText(fruit.name)
        Glide.with(context).load(fruit.imageId).into(holder.fruitImage)
    }

    override fun getItemCount()=fruitList.size
}