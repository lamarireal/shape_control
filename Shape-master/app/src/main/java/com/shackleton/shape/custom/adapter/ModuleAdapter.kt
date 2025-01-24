package com.shackleton.shape.custom.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shackleton.shape.R
import com.shackleton.shape.databinding.ModuleAdapterBinding
import com.shackleton.shape.db.laravel.model.Module


class ModuleAdapter(var lista:MutableList<Module>, private var listener: (Module)->Unit):RecyclerView.Adapter<ModuleAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.module_adapter, parent, false)
            return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(lista[position], position)

        holder.binding.button.setOnClickListener {
            listener(lista[position])
        }
    }

    override fun getItemCount(): Int = lista.size

    class ViewHolder (view: View): RecyclerView.ViewHolder(view) {
        val binding = ModuleAdapterBinding.bind(view)

        fun bind (list: Module, position: Int){
            val textColor: Int
            val backgroundColor: Int
            val btnColor: Int

            val white = Color.rgb(255,255,255)
            val blue = Color.rgb(24, 0, 197)
            val black = Color.rgb(0,0,0)

            when (position.mod(3)) {
                0 -> {
                    textColor = black
                    backgroundColor = white
                    btnColor = blue
                }
                1 -> {
                    textColor = white
                    backgroundColor = black
                    btnColor = blue
                }
                2 -> {
                    textColor = white
                    backgroundColor = blue
                    btnColor = black
                }
                else -> {
                    textColor = black
                    backgroundColor = white
                    btnColor = blue
                }
            }

            with(binding){
                title.text = list.title
                description.text = list.description
                button.text = list.button_text
                Glide.with(imagenReto).load(list.url).into(imagenReto)
                title.setTextColor(textColor)
                description.setTextColor(textColor)
                button.setBackgroundColor(btnColor)
                adapterCard.setBackgroundColor(backgroundColor)
            }
        }
    }

}

