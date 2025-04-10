package com.shackleton.shape.view.home.fragment.homeFragmentNav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.shackleton.shape.custom.adapter.ModuleAdapter
import com.shackleton.shape.databinding.FragmentGestorBinding
import com.shackleton.shape.view.home.ModuleViewModel

class GestorFragment : Fragment() {

    private var _binding: FragmentGestorBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: ModuleAdapter
    private val viewModel: ModuleViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGestorBinding.inflate(inflater, container, false)

        val ocultos = viewModel.getHiddenModules().toMutableList()

        adapter = ModuleAdapter(
            lista = ocultos,
            modo = "GESTOR",
            listener = { },
            onMostrar = { module ->
                viewModel.setModuleVisible(module.id, true)
                val nuevosOcultos = viewModel.getHiddenModules()
                adapter.updateData(nuevosOcultos)
            }
        )

        binding.recyclerGestor.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerGestor.adapter = adapter

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
