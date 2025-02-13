package com.shackleton.shape.view.home.fragment.homeActivityNav

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shackleton.shape.R
import com.shackleton.shape.custom.adapter.MindfullnesAdapter
import com.shackleton.shape.databinding.ActivityMindfullnesBinding
import com.shackleton.shape.db.laravel.model.Mindfullnes

class MindfullnesActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMindfullnesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMindfullnesBinding.inflate(layoutInflater)
        setContentView(binding.root)





        binding.recyclerMindfullnes.adapter = MindfullnesAdapter(cargarList())

    }

    private fun cargarList(): List<Mindfullnes> {
        return listOf(
            Mindfullnes(
                getString(R.string.notificacionesTitle),
                getString(R.string.notificacionesDescription),
                getString(R.string.notificacionesButton),
                "https://images.unsplash.com/photo-1596526131083-e8c633c948d2?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHwzfHxub3RpZmljYXRpb258ZW58MXx8fHwxNjgyNDk1NTQx&ixlib=rb-4.0.3&q=80&w=1080"
            ),
            Mindfullnes(
                getString(R.string.respiroTitle),
                getString(R.string.respiroDescription),
                getString(R.string.respiroButton),
                "https://images.unsplash.com/photo-1518708909080-704599b19972?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHwzfHxicmVhdGh8ZW58MXx8fHwxNjgyNDk1NTY0&ixlib=rb-4.0.3&q=80&w=1080"
            ),
        )
    }
}