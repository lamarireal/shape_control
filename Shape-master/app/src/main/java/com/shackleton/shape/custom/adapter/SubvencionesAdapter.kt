package com.shackleton.shape.custom.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shackleton.shape.R
import com.shackleton.shape.databinding.SubvencionesAdapterBinding
import com.shackleton.shape.db.laravel.model.Subvenciones


class SubvencionesAdapter(var lista:List<Subvenciones>): RecyclerView.Adapter<SubvencionesAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.subvenciones_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(lista[position])
    }

    override fun getItemCount(): Int = lista.size

    class ViewHolder (view: View): RecyclerView.ViewHolder(view) {
        val binding = SubvencionesAdapterBinding.bind(view)

        fun bind (list: Subvenciones){
            with(binding){
                title.text = list.title
                description.text = list.description
                button.text = list.button
                Glide.with(imagenReto).load(list.url).into(imagenReto)
            }
        }

    }
}