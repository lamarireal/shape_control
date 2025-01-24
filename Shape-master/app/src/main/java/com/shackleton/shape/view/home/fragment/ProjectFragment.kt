package com.shackleton.shape.view.home.fragment

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.shackleton.shape.R
import com.shackleton.shape.custom.adapter.ProjectAdapter
import com.shackleton.shape.databinding.FragmentProjectBinding
import com.shackleton.shape.db.laravel.model.Proyecto
import com.shackleton.shape.db.laravel.request.getAuthHeader
import com.shackleton.shape.db.laravel.request.openConnection
import com.shackleton.shape.db.laravel.request.response.GeneralResponse2
import com.shackleton.shape.db.laravel.request.service.ProjectAPI
import com.shackleton.shape.view.home.MainHome
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProjectFragment : Fragment() {

    private var _binding: FragmentProjectBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupProjectList()

        binding.btnCrearProyecto.setOnClickListener {
            showCreateProjectDialog()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProjectBinding.inflate(inflater, container, false)
        (activity as? MainHome)?.setBottomNavigationVisibility(View.VISIBLE)

        return binding.root
    }

    private fun setupProjectList() {
        openConnection().create(ProjectAPI::class.java).getProjects(getAuthHeader())
            .enqueue(object : Callback<List<Proyecto>> {
                override fun onResponse(
                    call: Call<List<Proyecto>>,
                    response: Response<List<Proyecto>>
                ) {
                    if (response.isSuccessful) {
                        val listaProyecto = response.body()
                        binding.recycler.adapter = listaProyecto?.let { ProjectAdapter(it, binding.root, requireActivity()) }
                    }
                }

                override fun onFailure(call: Call<List<Proyecto>>, t: Throwable) {
                    println("Error ${t.message}")
                }
            })
    }

    private fun showCreateProjectDialog() {
        val alertDialog = AlertDialog.Builder(context)
        val inflater = requireActivity().layoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_create_project, null)
        val editTextNombre = dialogView.findViewById<EditText>(R.id.editTextNombre)
        val editTextDescripcion = dialogView.findViewById<EditText>(R.id.editTextDescripcion)

        alertDialog.apply {
            setTitle("Crear Proyecto")
            setView(dialogView)
            setPositiveButton("Crear") { dialog, _ ->
                val nombre = editTextNombre.text.toString()
                val descripcion = editTextDescripcion.text.toString()

                createProject(nombre, descripcion)

                dialog.dismiss()
            }
            setNegativeButton("Cancelar") { dialog, _ ->
                dialog.dismiss()
            }
        }.create().show()
    }

    private fun createProject(nombre: String, descripcion: String) {
        openConnection().create(ProjectAPI::class.java).createProject(getAuthHeader(), nombre, descripcion)
            .enqueue(object : Callback<GeneralResponse2<Proyecto>> {
                override fun onResponse(
                    call: Call<GeneralResponse2<Proyecto>>,
                    response: Response<GeneralResponse2<Proyecto>>
                ) {
                    if (response.isSuccessful) {
                        setupProjectList()
                    }
                }

                override fun onFailure(call: Call<GeneralResponse2<Proyecto>>, t: Throwable) {
                    println("Error ${t.message}")
                }
            })
    }
}