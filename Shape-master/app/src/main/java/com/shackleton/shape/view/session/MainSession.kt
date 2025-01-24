package com.shackleton.shape.view.session

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shackleton.shape.databinding.ActivityMainSessionBinding

class MainSession : AppCompatActivity() {

    private lateinit var binding: ActivityMainSessionBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainSessionBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

}