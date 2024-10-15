package com.example.fragment

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.composetutorial.R
import com.example.composetutorial.databinding.ActivityFragmentTestBinding

class FragmentTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFragmentTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val button :Button = findViewById(R.id.button)
        button.setOnClickListener {
            replaceFragment(AnotherRightFragmnet())
        }
        replaceFragment(RightFragment())
    }

    private fun  replaceFragment(fragment:Fragment){
        val fragmentManager = supportFragmentManager
        val transcation = fragmentManager.beginTransaction()
        transcation.replace(R.id.rightLayout,fragment)
        transcation.addToBackStack(null)
        transcation.commit()
    }
}