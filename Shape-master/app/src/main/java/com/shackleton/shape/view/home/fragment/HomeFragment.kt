package com.shackleton.shape.view.home.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.shackleton.shape.R
import com.shackleton.shape.custom.adapter.ModuleAdapter
import com.shackleton.shape.db.laravel.controller.ModuleController
import com.shackleton.shape.databinding.FragmentHomeBinding
import com.shackleton.shape.db.laravel.model.Module
import com.shackleton.shape.view.home.MainHome
import kotlinx.coroutines.launch
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class   HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private lateinit var adapter : ModuleAdapter

    private val moduleController = ModuleController()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        (activity as? MainHome)?.setBottomNavigationVisibility(View.VISIBLE)
        val cargar = cargarList()
        binding.recycler.adapter = ModuleAdapter(cargar.toMutableList()){ module->
            when (module.id){
                1 -> {
                    findNavController().navigate(
                        HomeFragmentDirections.actionHomeFragmentToRetoActivity()
                    )
                }
                2 -> {
                    findNavController().navigate(
                        HomeFragmentDirections.actionHomeFragmentToEvaluaActivity()
                    )
                }
                3 -> {
                    findNavController().navigate(
                        HomeFragmentDirections.actionHomeFragmentToInspirateBinding()
                    )
                }
                4 -> {
                    findNavController().navigate(
                        HomeFragmentDirections.actionHomeFragmentToHerramientasActivity()
                    )
                }
                5 -> {
                    findNavController().navigate(
                        HomeFragmentDirections.actionHomeFragmentToNetworkingActivity()
                    )
                }
                6 -> {
                    findNavController().navigate(
                        HomeFragmentDirections.actionHomeFragmentToLienzosActivity()
                    )
                }
                7 -> {
                    findNavController().navigate(
                        HomeFragmentDirections.actionHomeFragmentToMindfullnesActivity()
                    )
                }
                8 -> {
                    findNavController().navigate(
                        HomeFragmentDirections.actionHomeFragmentToSubvencionesActivity()
                    )
                }
            }
        }

        return binding.root

    }
    private fun cargarList(): List<Module> {
        val lista = listOf(
            Module(1, getString(R.string.retoTitle),getString(R.string.retoDescription), getString(R.string.retoButton), "https://images.unsplash.com/photo-1453475250267-163ff185e88e?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHwzfHxtb2xlc2tpbmV8ZW58MXx8fHwxNjc2OTA2NDgy&ixlib=rb-4.0.3&q=80&w=1080"),
            Module(2, getString(R.string.evaluaTitle), getString(R.string.evaluaDescription), getString(R.string.evaluaButton), "https://images.unsplash.com/photo-1592312040834-bb0d621713e1?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHwyMXx8cGFwZXJzfGVufDF8fHx8MTY3NjkwNjM1Mg&ixlib=rb-4.0.3&q=80&w=1080"),
            Module(3, getString(R.string.inspirateTitle), getString(R.string.inspirateDescription), getString(R.string.inspirateButton), "https://images.unsplash.com/photo-1525972385596-02ad3049150b?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHw2NHx8Y3JlYXRpdmUlMjB0b29sc3xlbnwxfHx8fDE2Nzc2NjE4OTg&ixlib=rb-4.0.3&q=80&w=1080"),
            Module(4, getString(R.string.herramientasTitle), getString(R.string.herramientasDescription), getString(R.string.herramientasButton), "https://images.unsplash.com/photo-1516383740770-fbcc5ccbece0?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHwzOHx8aW5zcGlyYXRpb258ZW58MXx8fHwxNjc2OTA2NDIw&ixlib=rb-4.0.3&q=80&w=1080"),
            Module(5, getString(R.string.networkingTitle), getString(R.string.networkingDescription),getString(R.string.networkingButton), "https://images.unsplash.com/photo-1542744173-8e7e53415bb0?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHwxMnx8ZXZlbnQlMjBtYXJrZXRpbmd8ZW58MXx8fHwxNjc3NjYxOTc1&ixlib=rb-4.0.3&q=80&w=1080"),
            Module(6, getString(R.string.lienzosTitle), getString(R.string.lienzosDescription), getString(R.string.lienzosButton), "https://images.unsplash.com/photo-1522542550221-31fd19575a2d?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHwxN3x8ZGVzaWduJTIwdGhpbmtpbmd8ZW58MXx8fHwxNjc3NjYyMTk5&ixlib=rb-4.0.3&q=80&w=1080"),
            Module(7, getString(R.string.concentrateTitle), getString(R.string.concentrateDescription), getString(R.string.concentrateButton), "https://images.unsplash.com/photo-1621090483697-29b32b735a73?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHw2fHxtaW5kZnVsbmVzc3xlbnwxfHx8fDE2Nzc3NTExMTg&ixlib=rb-4.0.3&q=80&w=1080"),
            Module(8, getString(R.string.subvencionTitle), getString(R.string.subvencionDescription), getString(R.string.subvencionButton), "https://images.unsplash.com/photo-1590283603385-17ffb3a7f29f?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHw3fHxmaW5hbmNlfGVufDF8fHx8MTY4MjQxNTE5Ng&ixlib=rb-4.0.3&q=80&w=1080")
        )
        return lista
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //doSomeAsyncWork()
    }

    private suspend fun noneModuleSelected() : List<Module> = suspendCoroutine{
        moduleController.getSelectedModules { modules ->
            if (modules!!.isEmpty()){
                it.resume(listOf())
            }else{
                it.resume(modules)
            }
        }
    }
    private suspend fun getAllModules() : List<Module> = suspendCoroutine{
        moduleController.getAllModules { modules ->
            if (modules!=null){
                it.resume(modules)
            }else{
                it.resumeWithException(IllegalStateException("Modules are null"))
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun doSomeAsyncWork() {
        lifecycleScope.launch {
            try {
                val selectedModules = noneModuleSelected()

                if (selectedModules.isEmpty()) {
                    val allModules = getAllModules()
                    handleModules(allModules,true)
                } else {
                    handleModules(selectedModules, false)
                }
            } catch (e: Exception) {
                handleError(e)
            }
        }
    }
    private fun handleModules(modules: List<Module>?, isSettings: Boolean) {

        if (modules != null) {
            if (isSettings) {
                adapter = ModuleAdapter(modules.toMutableList()){
                    when (it.id){
                        1 -> {
                            findNavController().navigate(
                                HomeFragmentDirections.actionHomeFragmentToRetoActivity()
                            )
                        }
                        2 -> {
                            findNavController().navigate(
                                HomeFragmentDirections.actionHomeFragmentToEvaluaActivity()
                            )
                        }
                        3 -> {
                            findNavController().navigate(
                                HomeFragmentDirections.actionHomeFragmentToInspirateBinding()
                            )
                        }
                        4 -> {
                            findNavController().navigate(
                                HomeFragmentDirections.actionHomeFragmentToHerramientasActivity()
                            )
                        }
                        5 -> {
                            findNavController().navigate(
                                HomeFragmentDirections.actionHomeFragmentToNetworkingActivity()
                            )
                        }
                        6 -> {
                            findNavController().navigate(
                                HomeFragmentDirections.actionHomeFragmentToLienzosActivity()
                            )
                        }
                        7 -> {
                            findNavController().navigate(
                                HomeFragmentDirections.actionHomeFragmentToMindfullnesActivity()
                            )
                        }
                        8 -> {
                            findNavController().navigate(
                                HomeFragmentDirections.actionHomeFragmentToSubvencionesActivity()
                            )
                        }
                    }
                }
                binding.recycler.adapter = adapter
            } else {
                adapter = ModuleAdapter(modules.toMutableList()){
                    when (it.id){
                        1 -> {
                            findNavController().navigate(
                                HomeFragmentDirections.actionHomeFragmentToRetoActivity()
                            )
                        }
                        2 -> {
                            findNavController().navigate(
                                HomeFragmentDirections.actionHomeFragmentToEvaluaActivity()
                            )
                        }
                        3 -> {
                            findNavController().navigate(
                                HomeFragmentDirections.actionHomeFragmentToInspirateBinding()
                            )
                        }
                        4 -> {
                            findNavController().navigate(
                                HomeFragmentDirections.actionHomeFragmentToHerramientasActivity()
                            )
                        }
                        5 -> {
                            findNavController().navigate(
                                HomeFragmentDirections.actionHomeFragmentToNetworkingActivity()
                            )
                        }
                        6 -> {
                            findNavController().navigate(
                                HomeFragmentDirections.actionHomeFragmentToLienzosActivity()
                            )
                        }
                        7 -> {
                            findNavController().navigate(
                                HomeFragmentDirections.actionHomeFragmentToMindfullnesActivity()
                            )
                        }
                        8 -> {
                            findNavController().navigate(
                                HomeFragmentDirections.actionHomeFragmentToSubvencionesActivity()
                            )
                        }
                    }
                }
                binding.recycler.adapter = adapter
            }
        } else {
            Toast.makeText(requireContext(),"Algo Paso con la red", Toast.LENGTH_SHORT).show()
        }
    }

    private fun handleError(exception: Exception) {
        println("Error al obtener $exception")
        Toast.makeText(requireContext(),"Error al obtener $exception", Toast.LENGTH_SHORT).show()
    }

}