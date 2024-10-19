package com.example.materialtest

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.composetutorial.R
import com.example.composetutorial.databinding.ActivityMaterialTestBinding
import com.google.android.material.snackbar.Snackbar
import kotlin.concurrent.thread

class MaterialTestActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMaterialTestBinding

    val fruits= mutableListOf(Fruits("Apple", R.drawable.apple),Fruits("Banana", R.drawable.banana),Fruits("Orange", R.drawable.orange),Fruits("Watermelonn", R.drawable.watermelon),
        Fruits("Pear", R.drawable.pear),Fruits("Grape", R.drawable.grape),Fruits("Pineapple", R.drawable.pineapple),Fruits("Strawberry", R.drawable.strawberry),
        Fruits("Cherry", R.drawable.cherry),Fruits("Mango", R.drawable.mango))

    val fruitList = ArrayList<Fruits>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMaterialTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toobar)
        binding.swipeRefresh.setColorSchemeResources(R.color.teal_200)
        initFruits()
        val layoutManager =GridLayoutManager(this,2)
        binding.recyclerView.layoutManager =layoutManager
        val adapter = FruitsAdapter(this,fruitList)
        binding.recyclerView.adapter=adapter
        binding.swipeRefresh.setOnRefreshListener {
            refreshFruits(adapter)
        }
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.ic_menu)
        }

        binding.navView.setCheckedItem(R.id.navCall)
        binding.navView.setNavigationItemSelectedListener {
            binding.drawerLayout.closeDrawers()
            true
        }

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view,"Data deleted", Snackbar.LENGTH_SHORT).setAction("Undo"){
                Toast.makeText(this,"Data restored",Toast.LENGTH_SHORT).show()
            }
                .show()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun refreshFruits(adapter: FruitsAdapter) {
        thread {
            Thread.sleep(2000)
            runOnUiThread {
                initFruits()
                adapter.notifyDataSetChanged()
                binding.swipeRefresh.isRefreshing =false
            }
        }
    }

    private fun initFruits() {
        fruitList.clear()
        repeat(50){
            val index = (0 until fruits.size).random()
            fruitList.add(fruits[index])
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home ->binding.drawerLayout.openDrawer(GravityCompat.START)
            R.id.backup-> Toast.makeText(this,"You clicked Backup",Toast.LENGTH_SHORT).show()
            R.id.settings-> Toast.makeText(this,"You clicked Settings",Toast.LENGTH_SHORT).show()
            R.id.delete-> Toast.makeText(this,"You clicked Delete",Toast.LENGTH_SHORT).show()
        }
        return true
    }
}