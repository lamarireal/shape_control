package com.shackleton.shape.custom.adapter


import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shackleton.shape.R
import com.shackleton.shape.databinding.PostsAdapterBinding
import com.shackleton.shape.db.laravel.model.Comment
import com.shackleton.shape.db.laravel.model.Post
import com.shackleton.shape.db.laravel.request.getAuthHeader
import com.shackleton.shape.db.laravel.request.openConnection
import com.shackleton.shape.db.laravel.request.response.GeneralListResponse
import com.shackleton.shape.db.laravel.request.response.GeneralResponse2
import com.shackleton.shape.db.laravel.request.service.PostAPI
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PostAdapter(var lista: List<Post>, private val view: View) :
    RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    private var lastPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.posts_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(lista[position], view)
        setAnimation(holder.itemView, position)
        holder.binding.answersLinearLayout.visibility =
            if (lista[position].isExpandable()) View.VISIBLE else View.GONE

        holder.binding.downfeedback.setOnClickListener {
            isAnyItemExpanded(holder.bindingAdapterPosition)
            lista[position].setExpandable(!lista[position].isExpandable())
            notifyItemChanged(holder.bindingAdapterPosition)
        }
    }

    override fun getItemCount(): Int = lista.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = PostsAdapterBinding.bind(view)

        fun bind(list: Post, view: View) {
            with(binding) {
                idea.text = list.descripcion
                answersLinearLayout.visibility = View.GONE
                nombreUser.text = list.nick
                if (list.image_url != null) {
                    imagenPost.visibility = View.VISIBLE
                    Picasso.get().load(list.image_url).into(imagenPost)
                }
                Picasso.get().load(list.user_image_url).into(imagenPerfil)

                commentSection.setOnClickListener {
                    openConnection().create(PostAPI::class.java)
                        .getComments(getAuthHeader(), list.id)
                        .enqueue(object : Callback<GeneralListResponse<Comment>> {
                            override fun onResponse(
                                call: Call<GeneralListResponse<Comment>>,
                                response: Response<GeneralListResponse<Comment>>
                            ) {
                                if (response.isSuccessful) {

                                    val commentString = StringBuilder()
                                    response.body()?.data?.forEach { comment ->
                                        commentString.append("${comment.comment}\n")
                                    }

                                    showDialog(commentString.toString(), view, list.id)

                                } else {
                                    Toast.makeText(
                                        view.context,
                                        "Error en la respuesta del servidor",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }

                            override fun onFailure(
                                call: Call<GeneralListResponse<Comment>>,
                                t: Throwable
                            ) {
                                println("Error ${t.message}")
                                Toast.makeText(
                                    view.context,
                                    "Error de conexión",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        })
                }

            }
        }

        private fun showDialog(comentarios: String, view: View, id: Int) {
            val dialog = Dialog(view.context)
            dialog.setContentView(R.layout.custom_comment_dialog)

            val recyclerView: RecyclerView = dialog.findViewById(R.id.recyclerViewComments)
            val editText: EditText = dialog.findViewById(R.id.editTextComment)
            val imageView: ImageView = dialog.findViewById(R.id.imageViewSend)

            val lista = parseComments(comentarios)
            val adapter = CommentAdapter(lista)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(view.context)

            imageView.setOnClickListener {
                val newComment = editText.text.toString().trim()
                if (newComment.isNotEmpty()) {
                    openConnection().create(PostAPI::class.java)
                        .uploadComment(getAuthHeader(), id, newComment)
                        .enqueue(object : Callback<GeneralResponse2<CommentS>> {
                            override fun onResponse(
                                call: Call<GeneralResponse2<CommentS>>,
                                response: Response<GeneralResponse2<CommentS>>
                            ) {
                                if (response.isSuccessful) {
                                    val newComment = response.body()?.data
                                    newComment?.let {
                                        lista.add(newComment)
                                        adapter.notifyItemInserted(lista.size - 1)
                                        recyclerView.smoothScrollToPosition(lista.size - 1)
                                    }
                                    editText.text.clear()
                                }
                            }

                            override fun onFailure(
                                call: Call<GeneralResponse2<CommentS>>,
                                t: Throwable
                            ) {
                                println("Error ${t.message}")
                                Toast.makeText(
                                    view.context,
                                    "Error de conexión",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        })
                }
            }

            dialog.show()
        }


        private fun parseComments(commentsString: String?): MutableList<CommentS> {
            val comments = mutableListOf<CommentS>()
            commentsString?.split("\n")?.forEach { comment ->
                comments.add(CommentS("", "", comment))
            }
            comments.removeAt(comments.size - 1)
            return comments
        }


    }

    private fun isAnyItemExpanded(position: Int) {
        var temp = -1
        for (i in lista.indices) {
            if (lista[i].isExpandable()) {
                temp = i
                break
            }
        }
        if (temp >= 0 && temp != position) {
            lista[temp].setExpandable(false)
            notifyItemChanged(temp)
        }
    }


    private fun setAnimation(viewToAnimate: View, position: Int) {
        if (position > lastPosition) {
            val animation: Animation = AnimationUtils.loadAnimation(view.context, R.anim.scale_up)
            viewToAnimate.startAnimation(animation)
            lastPosition = position
        }
    }
}