package com.shackleton.shape.view.home.fragment.homeFragmentNav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shackleton.shape.R
import com.shackleton.shape.custom.adapter.InspirateAdapter
import com.shackleton.shape.databinding.FragmentInspirateMainBinding
import com.shackleton.shape.db.laravel.model.Inspirate

class InspirateMainFragment : Fragment() {


    private var _binding: FragmentInspirateMainBinding? = null

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInspirateMainBinding.inflate(inflater, container, false)
        binding.recyclerInspirate.adapter = InspirateAdapter(cargarList(), binding.root.rootView)

        return binding.root
    }
    private fun cargarList(): List<Inspirate> {
        return listOf(
            Inspirate(
                getString(R.string.casosTitle),
                getString(R.string.casosDescription),
                getString(R.string.botonInspirate),
                "https://images.unsplash.com/photo-1568659358810-bdbdb4decb5c?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHw0OHx8cXVvdGV8ZW58MXx8fHwxNjc4Nzk4MzU4&ixlib=rb-4.0.3&q=80&w=1080"
            ),
            Inspirate(
                getString(R.string.podcastTitle),
                getString(R.string.posdcastDescription),
                getString(R.string.botonInspirate),
                "https://images.unsplash.com/photo-1619490287893-862fd1808407?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHw4fHxwb2RjYXN0c3xlbnwxfHx8fDE2Nzg3OTgwMzA&ixlib=rb-4.0.3&q=80&w=1080"
            ),
            Inspirate(
                getString(R.string.frasesTitle),
                getString(R.string.frasesDescription),
                getString(R.string.botonInspirate),
                "https://images.unsplash.com/photo-1569775931713-52512a1f1b96?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHwxNDN8fHF1b3Rlc3xlbnwxfHx8fDE2Nzg3OTg0MTA&ixlib=rb-4.0.3&q=80&w=1080"
            ),
        )
    }

}