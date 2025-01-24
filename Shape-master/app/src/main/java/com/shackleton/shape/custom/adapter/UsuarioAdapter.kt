package com.shackleton.shape.custom.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.shackleton.shape.R
import com.shackleton.shape.databinding.UsuarioAdapterBinding
import com.shackleton.shape.db.laravel.model.User
import com.shackleton.shape.view.home.fragment.SearchFragmentDirections
import com.squareup.picasso.Picasso


class UsuarioAdapter(
    var lista: MutableList<User>,
    private var context: Context,
    private var root: ConstraintLayout
): RecyclerView.Adapter<UsuarioAdapter.ViewHolder>(){

    private var lastPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.usuario_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(lista[position],context,root)
        setAnimation(holder.itemView,position)
    }

    override fun getItemCount(): Int = lista.size

    class ViewHolder (view: View): RecyclerView.ViewHolder(view) {
        val binding = UsuarioAdapterBinding.bind(view)

        fun bind (list: User, context: Context, root: ConstraintLayout){
            with(binding){
                Picasso.get().load(list.user_image_url).into(imagenPerfil)
                nombreUsuario.text = list.full_name
                nickUsuario.text = list.nick
                val arr = arrayOf(list.nick,list.id.toString())
                cartaEventoUsuario.setOnClickListener {
                    root.findNavController().navigate(SearchFragmentDirections.actionSearchFragment3ToUserSelectedFragment(parameter = arr))
                }
            }
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    fun setFilteredList(listaUsuarios: MutableList<User>) {
        lista = listaUsuarios
        notifyDataSetChanged()
    }

    private fun setAnimation(viewToAnimate: View, position: Int) {
        if (position > lastPosition) {
            val animation: Animation = AnimationUtils.loadAnimation(context, R.anim.scale_up)
            viewToAnimate.startAnimation(animation)
            lastPosition = position
        }
    }
}
