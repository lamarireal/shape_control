package com.shackleton.shape.view.home.fragment.homeActivityNav

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shackleton.shape.databinding.ActivityEvaluaBinding

class EvaluaActivity : AppCompatActivity() {

     private lateinit var binding : ActivityEvaluaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEvaluaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.arrowBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }


    }
}