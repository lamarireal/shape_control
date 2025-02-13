package com.shackleton.shape.view.home.fragment.homeActivityNav

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shackleton.shape.databinding.ActivityInspirateBindingBinding

class InspirateActivity : AppCompatActivity() {

    private lateinit var binding : ActivityInspirateBindingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInspirateBindingBinding.inflate(layoutInflater)
        setContentView(binding.root)






    }

}