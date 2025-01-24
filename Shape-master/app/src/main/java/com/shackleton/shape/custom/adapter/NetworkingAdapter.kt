package com.shackleton.shape.custom.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shackleton.shape.R
import com.shackleton.shape.databinding.NetworkingAdapterBinding
import com.shackleton.shape.db.laravel.model.Networking

class NetworkingAdapter(var lista:List<Networking>): RecyclerView.Adapter<NetworkingAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.networking_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(lista[position])
    }

    override fun getItemCount(): Int = lista.size

    class ViewHolder (view: View): RecyclerView.ViewHolder(view) {
        val binding = NetworkingAdapterBinding.bind(view)

        fun bind (list: Networking){
            with(binding){
                title.text = list.title
                description.text = list.description
                Glide.with(imageView).load(list.url).into(imageView)
            }
        }

    }
}