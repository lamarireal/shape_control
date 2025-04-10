package com.shackleton.shape.custom.adapter

import android.app.AlertDialog
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shackleton.shape.R
import com.shackleton.shape.databinding.ModuleAdapterBinding
import com.shackleton.shape.db.laravel.model.Module

class ModuleAdapter(
    private val lista: MutableList<Module>,
    private val modo: String,
    private val listener: (Module) -> Unit,
    private val onOcultar: ((Module) -> Unit)? = null,
    private val onMostrar: ((Module) -> Unit)? = null
) : RecyclerView.Adapter<ModuleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.module_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val module = lista[position]
        holder.bind(module)

        holder.binding.button.setOnClickListener {
            listener(module)
        }

        val btnAccion = holder.binding.root.findViewById<ImageButton>(R.id.btnOcultar)

        if (modo == "HOME") {
            btnAccion.setImageResource(android.R.drawable.ic_delete)
            btnAccion.setOnClickListener {
                val context = holder.itemView.context
                AlertDialog.Builder(context)
                    .setTitle("¿Quitar del Home?")
                    .setMessage("¿Estás seguro de que quieres quitar esta tarjeta?")
                    .setPositiveButton("Sí") { _, _ ->
                        onOcultar?.invoke(module)
                    }
                    .setNegativeButton("Cancelar", null)
                    .show()
            }
        } else if (modo == "GESTOR") {
            btnAccion.setImageResource(android.R.drawable.ic_input_add)
            btnAccion.setOnClickListener {
                onMostrar?.invoke(module)
            }
        }
    }

    override fun getItemCount(): Int = lista.size

    fun updateData(nuevaLista: List<Module>) {
        lista.clear()
        lista.addAll(nuevaLista)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ModuleAdapterBinding.bind(view)

        fun bind(module: Module) {
            val textColor: Int
            val backgroundColor: Int
            val btnColor: Int

            val white = Color.rgb(255, 255, 255)
            val blue = Color.rgb(24, 0, 197)
            val black = Color.rgb(0, 0, 0)

            when (module.id % 3) {
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

            with(binding) {
                title.text = module.title
                description.text = module.description
                button.text = module.button_text

                // Mejora en la carga de imagen
                Glide.with(imagenReto.context)
                    .load(module.url)
                    .thumbnail(0.1f)
                    .into(imagenReto)

                title.setTextColor(textColor)
                description.setTextColor(textColor)
                button.setBackgroundColor(btnColor)
                adapterCard.setBackgroundColor(backgroundColor)
            }
        }
    }
}
