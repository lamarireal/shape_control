package com.shackleton.shape.view.home.fragment.homeActivityNav

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shackleton.shape.R
import com.shackleton.shape.custom.adapter.NetworkingAdapter
import com.shackleton.shape.databinding.ActivityNetworkingBinding
import com.shackleton.shape.db.laravel.model.Networking

class NetworkingActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNetworkingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNetworkingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerNetworking.adapter = NetworkingAdapter(cargarList())

    }
    private fun cargarList(): List<Networking> {
        return listOf(
            Networking(
                getString(R.string.nightsTitle),
                getString(R.string.nightsDescription),
                "https://images.unsplash.com/photo-1515169067868-5387ec356754?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHw4fHxuZXR3b3JraW5nfGVufDF8fHx8MTY4MDYwNTkzNA&ixlib=rb-4.0.3&q=80&w=1080"
            ),
            Networking(
                getString(R.string.comedyTitle),
                getString(R.string.comedyDescription),
                "https://images.unsplash.com/photo-1543584756-8f40a802e14f?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHwxfHxzdGFuZHVwJTIwY29tZWR5fGVufDF8fHx8MTY4MDYwNjA0OA&ixlib=rb-4.0.3&q=80&w=1080"
            ),
            Networking(
                getString(R.string.pitchDeckTitle),
                getString(R.string.pitchDeckDescription),
                "https://images.unsplash.com/photo-1590098563686-06ab8778a6a7?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHwxfHxwaXRjaCUyMGRlY2t8ZW58MXx8fHwxNjgwNjA2MTEz&ixlib=rb-4.0.3&q=80&w=1080"
            ),
        )
    }
}