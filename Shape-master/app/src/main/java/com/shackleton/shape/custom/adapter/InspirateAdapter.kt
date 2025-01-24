package com.shackleton.shape.custom.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.shackleton.shape.R
import com.shackleton.shape.databinding.InspirateAdapterBinding
import com.shackleton.shape.db.laravel.model.Inspirate
import com.shackleton.shape.view.home.fragment.homeFragmentNav.InspirateMainFragmentDirections
import com.squareup.picasso.Picasso


class InspirateAdapter(private var lista:List<Inspirate>, view: View): RecyclerView.Adapter<InspirateAdapter.ViewHolder>(){

    private val v =view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.inspirate_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(lista[position])
        when (position) {
            0 -> {
                holder.binding.btn.setOnClickListener{
                    Navigation.findNavController(v).navigate(InspirateMainFragmentDirections.actionInspirateMainFragmentToSuccesCasesFragment())
                }
            }
            1 -> {
                holder.binding.btn.setOnClickListener{
                    Navigation.findNavController(v).navigate(InspirateMainFragmentDirections.actionInspirateMainFragmentToPodcastFragment())
                }
            }
            2 -> {
                holder.binding.btn.setOnClickListener{
                    Navigation.findNavController(v).navigate(InspirateMainFragmentDirections.actionInspirateMainFragmentToPhraseFragment())
                }
            }
        }
    }

    override fun getItemCount(): Int = lista.size

    class ViewHolder (view: View): RecyclerView.ViewHolder(view) {
        val binding = InspirateAdapterBinding.bind(view)

        fun bind (list: Inspirate){
            with(binding){

                tituloReto.text = list.title
                descripcionReto.text = list.description
                btn.text = list.button
                if(!list.url.contains("#&#&")){
                    Picasso.get().load(list.url).into(binding.imagenReto)
                }else{
                    Picasso.get().load(list.url.split("#&#&")[0]).into(binding.imagenReto)
                }
            }
        }
    }
}