package com.example.chatui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.composetutorial.databinding.ActivityUibestPracticeBinding

class UIBestPracticeActivity : AppCompatActivity(), View.OnClickListener {

    private val msgList = ArrayList<Msg>()
    private lateinit var  binding:ActivityUibestPracticeBinding
    private lateinit var adapter : MsgAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityUibestPracticeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initMsg()
        val layoutManager =LinearLayoutManager(this)
        binding.recyclerview.layoutManager =layoutManager
        adapter= MsgAdapter(msgList)
        binding.recyclerview.adapter=adapter
        binding.send.setOnClickListener(this)
    }

    private fun initMsg() {
        val msg1= Msg("Hello guy.", Msg.TYPE_RECEIVED)
        msgList.add(msg1)
        val msg2 = Msg("Hello. who is that?", Msg.TYPE_SENT)
        msgList.add(msg2)
        val msg3 = Msg("This is Tom,Nice talking to you.", Msg.TYPE_RECEIVED)
        msgList.add(msg3)
    }

    override fun onClick(v: View?) {
        when(v){
            binding.send ->{
                val content = binding.inputText.text.toString()
                if (content.isNotEmpty()){
                    val msg = Msg(content, Msg.TYPE_SENT)
                    msgList.add(msg)
                    adapter.notifyItemInserted(msgList.size-1)//当有新消息时，刷新列表显示
                    binding.recyclerview.scrollToPosition(msgList.size-1)//将recyclerview定位到最后一行
                    binding.inputText.setText("")//清空输入框内容
                }
            }
        }
    }

}