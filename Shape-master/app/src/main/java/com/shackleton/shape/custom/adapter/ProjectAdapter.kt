package com.shackleton.shape.custom.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.shackleton.shape.R
import com.shackleton.shape.databinding.ProjectAdapterBinding
import com.shackleton.shape.db.laravel.model.Proyecto
import com.shackleton.shape.view.home.fragment.ProjectFragmentDirections


class ProjectAdapter(var lista: List<Proyecto>,val root: LinearLayout, val v : FragmentActivity): RecyclerView.Adapter<ProjectAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.project_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(lista[position],root,v)

    }

    override fun getItemCount(): Int = lista.size

    class ViewHolder (view: View): RecyclerView.ViewHolder(view) {
        val binding = ProjectAdapterBinding.bind(view)
        fun bind (list: Proyecto, root: LinearLayout, v: FragmentActivity){
            with(binding){
                nombreProyecto.text = list.name
                val reformat = list.created_at.split("T")
                val reformat2 = reformat[1].split(".")
                val finalReformat = reformat[0] +" "+ reformat2[0]
                fechaCreacion.text = finalReformat

                btnEditProyecto.setOnClickListener {
                    val arr = arrayOf(list.id,list.name)
                    root.findNavController().navigate(ProjectFragmentDirections.actionProjectFragment4ToTimelineFragment2(parameters = arr))
                }
            }
        }
    }
}