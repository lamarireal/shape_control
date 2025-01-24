package com.shackleton.shape.custom.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.shackleton.shape.R
import com.shackleton.shape.databinding.InspirateAdapterBinding
import com.shackleton.shape.db.laravel.model.Inspirate
import com.squareup.picasso.Picasso

class PodcastAdapter(private var lista:List<Inspirate>, view: FragmentActivity): RecyclerView.Adapter<PodcastAdapter.ViewHolder>(){

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
                    val i = Intent(Intent.ACTION_VIEW)
                    i.data = Uri.parse("https://itnig.net/podcast/")
                    v.startActivity(i)
                }
            }
            1 -> {
                holder.binding.btn.setOnClickListener{
                    val i = Intent(Intent.ACTION_VIEW)
                    i.data = Uri.parse("https://www.youtube.com/watch?v=wJ1COwwyGKs")
                    v.startActivity(i)
                }
            }
            2 -> {
                holder.binding.btn.setOnClickListener{
                    val i = Intent(Intent.ACTION_VIEW)
                    i.data = Uri.parse("https://open.spotify.com/show/0Axsz7z8PrkX9jWRIqWwlJ")
                    v.startActivity(i)
                }
            }
            3 -> {
                holder.binding.btn.setOnClickListener{
                    val i = Intent(Intent.ACTION_VIEW)
                    i.data = Uri.parse("https://open.spotify.com/show/1QaQZxYMyasJFL8VYRqIYy")
                    v.startActivity(i)
                }
            }
            4 -> {
                holder.binding.btn.setOnClickListener{
                    val i = Intent(Intent.ACTION_VIEW)
                    i.data = Uri.parse("https://www.youtube.com/watch?v=xFPZlbugaMM&list=PLjZS-JWjiyRcvad6Jx4mpT53SAMW2yLEi&index=1")
                    v.startActivity(i)
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