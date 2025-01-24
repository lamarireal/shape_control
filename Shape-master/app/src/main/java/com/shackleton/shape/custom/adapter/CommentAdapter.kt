package com.shackleton.shape.custom.adapter

import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.annotations.SerializedName
import com.shackleton.shape.R
import com.shackleton.shape.databinding.CommentAdapterBinding
import kotlinx.parcelize.Parcelize

@Parcelize
data class CommentS(val url : String, val nick: String,@SerializedName("comment") val comment : String): Parcelable
class CommentAdapter(var lista:List<CommentS>): RecyclerView.Adapter<CommentAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.comment_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(lista[position])
    }

    override fun getItemCount(): Int = lista.size

    class ViewHolder (view: View): RecyclerView.ViewHolder(view) {
        val binding = CommentAdapterBinding.bind(view)

        fun bind (list: CommentS){
            with(binding){
                comentarioUser.text = list.comment
                //nickUser.text = list.nick
            }
        }

    }
}
