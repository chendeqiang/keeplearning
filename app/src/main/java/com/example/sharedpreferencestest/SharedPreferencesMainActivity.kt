package com.example.sharedpreferencestest

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.composetutorial.R
import com.example.composetutorial.databinding.ActivitySharedPreferencesMainBinding

class SharedPreferencesMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySharedPreferencesMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedPreferencesMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.saveButton.setOnClickListener {
            getSharedPreferences("data",Context.MODE_PRIVATE).edit {
                putString("name","Tom")
                putInt("age",28)
                putBoolean("married",false)
            }
//            val editor = getSharedPreferences("data", Context.MODE_PRIVATE).edit()
//            editor.putString("name","Tom")
//            editor.putInt("age",28)
//            editor.putBoolean("married",false)
//            editor.apply()
        }

        binding.restoreButton.setOnClickListener {
            val prefs = getSharedPreferences("data",Context.MODE_PRIVATE)
            val name = prefs.getString("name","")
            val age  = prefs.getInt("age",0)
            val married = prefs.getBoolean("married",false)
            Log.d("SharedPreferencesMainActivity","name is $name")
            Log.d("SharedPreferencesMainActivity","age is $age")
            Log.d("SharedPreferencesMainActivity","married is $married")

        }
    }
}