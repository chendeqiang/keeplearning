package com.example.broadcastreceiver.broadcastbestpractice

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.broadcastreceiver.BroadcastReceiverActivity
import com.example.composetutorial.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val prefs = getPreferences(Context.MODE_PRIVATE)
        val isRemember=prefs.getBoolean("remember_password",false)
        if (isRemember){
            val account = prefs.getString("account","")
            val password = prefs.getString("password","")
            binding.accountEdit.setText(account)
            binding.passwordEdit.setText(password)
            binding.rememberPass.isChecked =true
        }

        binding.login.setOnClickListener {
            val account = binding.accountEdit.text.toString()
            val password = binding.passwordEdit.text.toString()
            //如果账号是admin且密码是123456，就认为登录成功
            if (account == "admin" && password =="123456"){
                val editor = prefs.edit()
                if (binding.rememberPass.isChecked){
                    editor.putBoolean("remember_password",true)
                    editor.putString("account",account)
                    editor.putString("password",password)
                }else{
                    editor.clear()
                }
                editor.apply()

                val intent = Intent(this, BroadcastReceiverActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this,"account or password is invalid",Toast.LENGTH_SHORT).show()
            }
        }
    }
}