package com.shackleton.shape.custom.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shackleton.shape.R
import com.shackleton.shape.databinding.MindfullnesAdapterBinding
import com.shackleton.shape.db.laravel.model.Mindfullnes

class MindfullnesAdapter(var lista:List<Mindfullnes>): RecyclerView.Adapter<MindfullnesAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.mindfullnes_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(lista[position])
    }

    override fun getItemCount(): Int = lista.size

    class ViewHolder (view: View): RecyclerView.ViewHolder(view) {
        val binding = MindfullnesAdapterBinding.bind(view)

        fun bind (list: Mindfullnes){
            with(binding){
                title.text = list.title
                description.text = list.description
                button.text = list.button
                Glide.with(imagenReto).load(list.url).into(imagenReto)
            }
        }

    }
}