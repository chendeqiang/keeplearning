package com.example.playvideotest

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.composetutorial.R
import com.example.composetutorial.databinding.ActivityPlayVideoBinding

class PlayVideoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlayVideoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayVideoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val uri = Uri.parse("android.resource://$packageName/${R.raw.video}")
        binding.videoView.setVideoURI(uri)

        binding.play.setOnClickListener {
            if (!binding.videoView.isPlaying){
                binding.videoView.start()
            }
        }

        binding.pause.setOnClickListener {
            if (binding.videoView.isPlaying){
                binding.videoView.pause()
            }
        }

        binding.replay.setOnClickListener {
            if (binding.videoView.isPlaying){
                binding.videoView.resume()
            }
        }
    }
}