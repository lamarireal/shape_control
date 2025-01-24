package com.shackleton.shape.view.home.fragment.homeActivityNav

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shackleton.shape.databinding.ActivityRetoBinding

class RetoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRetoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRetoBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}