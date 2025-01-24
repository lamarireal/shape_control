package com.shackleton.shape.custom.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shackleton.shape.R
import com.shackleton.shape.databinding.BibliotecaAdapterBinding
import com.shackleton.shape.db.laravel.model.Biblioteca

class BibliotecaAdapter(private val bibliotecas: List<Biblioteca>, private val listener: OnItemClickListener) : RecyclerView.Adapter<BibliotecaAdapter.BibliotecaViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(biblioteca: Biblioteca)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BibliotecaViewHolder {
        val binding = BibliotecaAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BibliotecaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BibliotecaViewHolder, position: Int) {
        val currentItem = bibliotecas[position]
        holder.bind(currentItem)
    }

    override fun getItemCount() = bibliotecas.size

    inner class BibliotecaViewHolder(private val binding: BibliotecaAdapterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(biblioteca: Biblioteca) {
            binding.apply {
                title.text = biblioteca.title
                description.text = biblioteca.description
                Glide.with(itemView)
                    .load(biblioteca.url)
                    .centerCrop()
                    .into(imagenReto)
                button.setOnClickListener{
                    listener.onItemClick(biblioteca)
                }
            }
        }
    }
}
