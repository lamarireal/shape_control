package com.shackleton.shape.view.home.fragment.homeActivityNav.fragmentProjectNav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.shackleton.shape.R
import com.shackleton.shape.custom.adapter.TimelineAdapter
import com.shackleton.shape.databinding.FragmentTimelineBinding
import com.shackleton.shape.view.home.MainHome


class TimelineFragment : Fragment() {
    private var _binding: FragmentTimelineBinding? = null
    private val binding get() = _binding!!

    private val args: TimelineFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTimelineBinding.inflate(inflater, container, false)

        (activity as? MainHome)?.setBottomNavigationVisibility(View.GONE)

        val idP = args.parameters[0]
        val nameP = args.parameters[1]
        binding.recycler.adapter = TimelineAdapter(listaLienzos(),binding.root,idP,nameP)

        return binding.root
    }

    data class CanvasData(val name : String, val completado: String)

    private fun listaLienzos() : List<CanvasData>{

        return listOf(CanvasData("Modelo de negocio","No completado"),
            CanvasData("Lienzo de visión","No completado"),
            CanvasData("Lienzo validación ligera","No completado"),
            CanvasData("Lienzo propuesta de valor","No completado"),
            CanvasData("Lienzo lean project","No completado"))
    }


}