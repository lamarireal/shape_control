package com.shackleton.shape.view.home.fragment.homeFragmentNav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.shackleton.shape.custom.adapter.ModuleAdapter
import com.shackleton.shape.databinding.FragmentGestorBinding
import com.shackleton.shape.view.home.MainHome
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

        // Oculta la bottom navigation cuando entras
        (activity as? MainHome)?.setBottomNavigationVisibility(View.GONE)


        // el nav
        (activity as? MainHome)?.hideToolbar()





        setupRecycler()
        setupBackButton()

        return binding.root
    }

    private fun setupRecycler() {
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

        binding.recyclerGestor.layoutManager = GridLayoutManager(requireContext(), 1)
        binding.recyclerGestor.adapter = adapter
    }

    private fun setupBackButton() {
        binding.arrowBack.setOnClickListener {
            findNavController().navigateUp()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Vuelve a mostrar la bottom navigation al salir
        (activity as? MainHome)?.setBottomNavigationVisibility(View.VISIBLE)
        (activity as? MainHome)?.showToolbar()


        _binding = null
    }
}
