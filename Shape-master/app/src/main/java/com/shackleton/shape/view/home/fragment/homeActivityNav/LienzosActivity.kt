package com.shackleton.shape.view.home.fragment.homeActivityNav

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shackleton.shape.databinding.ActivityLienzosBinding

class LienzosActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLienzosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLienzosBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

}