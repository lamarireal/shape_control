package com.shackleton.shape.view.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.shackleton.shape.custom.adapter.ModuleAdapter
import com.shackleton.shape.databinding.FragmentHomeBinding
import com.shackleton.shape.view.home.ModuleViewModel
import com.shackleton.shape.view.home.MainHome

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    private val viewModel: ModuleViewModel by activityViewModels()
    private lateinit var adapter: ModuleAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        (activity as? MainHome)?.setBottomNavigationVisibility(View.VISIBLE)

        setupRecycler()
        setupBotonIrAGestor()

        return binding.root
    }

    private fun setupRecycler() {
        val visibles = viewModel.getVisibleModules()

        adapter = ModuleAdapter(
            lista = visibles.toMutableList(),
            modo = "HOME",
            listener = { module ->
                when (module.id) {
                    1 -> findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToRetoActivity())
                    2 -> findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToEvaluaActivity())
                    3 -> findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToInspirateBinding())
                    4 -> findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToHerramientasActivity())
                    5 -> findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToNetworkingActivity())
                    6 -> findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToLienzosActivity())
                    7 -> findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToMindfullnesActivity())
                    8 -> findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToSubvencionesActivity())
                }
            },
            onOcultar = { module ->
                viewModel.setModuleVisible(module.id, false)
                adapter.updateData(viewModel.getVisibleModules())
            }
        )

        binding.recycler.layoutManager = GridLayoutManager(requireContext(), 1)
        binding.recycler.adapter = adapter
    }

    private fun setupBotonIrAGestor() {
        binding.btnAnyadirFunciones.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToGestorFragment())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

