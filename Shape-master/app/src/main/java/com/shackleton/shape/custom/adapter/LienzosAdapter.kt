package com.shackleton.shape.custom.adapter

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shackleton.shape.R
import com.shackleton.shape.db.laravel.controller.ProjectController
import com.shackleton.shape.databinding.LienzosAdapterBinding
import com.shackleton.shape.db.laravel.model.Lienzos
import com.shackleton.shape.view.home.fragment.homeFragmentNav.LienzosMainFragmentDirections

class LienzosAdapter(var lista: List<Lienzos>): RecyclerView.Adapter<LienzosAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.lienzos_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(lista[position],position)
        if(position == 0){
            holder.binding.contL.visibility= View.GONE
        }
        when(position){
            0-> print("")
        }
    }

    override fun getItemCount(): Int = lista.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
         val binding = LienzosAdapterBinding.bind(view)


        fun bind(list: Lienzos, position: Int) {
            with(binding) {
                title.text = list.title
                description.text = list.description
                button.text = list.button
                Glide.with(imagenReto).load(list.url).into(imagenReto)
                button.setOnClickListener {
                    showAlertDialog(itemView, title.text as String,position)
                }
            }
        }

        private fun showAlertDialogWithIdeas(
            view: View,
            ideas: List<String>,
            text: String,
            position: Int
        ) {



            val builder = AlertDialog.Builder(view.context)
            builder.setTitle("Asociar Lienzo con un Proyecto")

            val spinnerLayout = LayoutInflater.from(view.context).inflate(R.layout.spin, null)
            val spinner = spinnerLayout.findViewById<Spinner>(R.id.ideaSpinner)
            val ml = mutableListOf<String>()

            for (s in ideas){
                val sas = s.split("###&&&")
                ml.add(sas[0])
            }

            val adapter = ArrayAdapter(view.context, android.R.layout.simple_spinner_item, ml)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter

            builder.setPositiveButton("Aceptar") { dialog, _ ->
                val selectedIdea = ideas[spinner.selectedItemPosition].split("###&&&")
                val projectID = selectedIdea[1]
                val listaP = arrayOf(selectedIdea[0],text,position.toString(),projectID)
                Navigation.findNavController(view).navigate(LienzosMainFragmentDirections.actionLienzosMainFragmentToLienzoSelectedFragment(parameters = listaP))
                dialog.dismiss()
            }

            builder.setNegativeButton("Cancelar") { dialog, _ ->
                dialog.dismiss()
            }

            builder.setView(spinnerLayout)
            val dialog = builder.create()
            dialog.show()
        }

        private fun showAlertDialogWithoutIdeas(view: View, text: String, position: Int) {
            val builder = AlertDialog.Builder(view.context)
            builder.setTitle("Asociar Lienzo con un Proyecto")
            builder.setMessage("No hay Proyectos disponibles")
            builder.setPositiveButton("Crear Proyecto con este lienzo") { dialog, _ ->
                val listaP = arrayOf("NO",text,position.toString())
                Navigation.findNavController(view).navigate(LienzosMainFragmentDirections.actionLienzosMainFragmentToLienzoSelectedFragment(parameters = listaP))
                Toast.makeText(view.context, "Creando Proyecto", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }

            val dialog = builder.create()
            dialog.show()
        }

        private fun showAlertDialog(view: View, text: String, position: Int) {
            val projectController = ProjectController()
            projectController.getProjects { projects ->
                if (projects.isNotEmpty()){
                    val mList = mutableListOf<String>()
                    for (p in projects){
                         mList.add("${p.name}###&&&${p.id}")
                    }
                    if (mList.isNotEmpty()) {
                        showAlertDialogWithIdeas(view, mList,text,position)
                    } else {
                        showAlertDialogWithoutIdeas(view,text,position)
                    }
                }else{
                    Toast.makeText(view.context, "Primero crea un proyecto o sube una idea", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }
}
