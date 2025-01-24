package com.shackleton.shape.custom.adapter

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.shackleton.shape.R
import com.shackleton.shape.db.laravel.controller.PDFController
import com.shackleton.shape.databinding.GoalLienzoAdapterBinding
import com.shackleton.shape.db.laravel.model.LienzoLean
import com.shackleton.shape.db.laravel.model.LienzoModelo
import com.shackleton.shape.db.laravel.model.LienzoPropuesta
import com.shackleton.shape.db.laravel.model.LienzoVision
import com.shackleton.shape.db.laravel.model.Statement
import com.shackleton.shape.db.laravel.request.getAuthHeader
import com.shackleton.shape.db.laravel.request.openConnection
import com.shackleton.shape.db.laravel.request.response.GeneralResponse2
import com.shackleton.shape.db.laravel.request.service.PDFAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class EnunciadosAdapter(
    private var v: FragmentActivity,
    var lista: List<Statement>,
    private val view: View,
    private var project_id: Int,
    private var pdf: Int,
    private val s: String
) : RecyclerView.Adapter<EnunciadosAdapter.ViewHolder>() {

    private var lastPosition = -1

    private val editPDF = PDFController()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.goal_lienzo_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(lista[position])

        val open = openConnection().create(PDFAPI::class.java)

        when(pdf){
            0->  open.getDataFromLienzoModelo(getAuthHeader(),s)
                .enqueue(object : Callback<GeneralResponse2<LienzoModelo>>{
                    override fun onResponse(
                        call: Call<GeneralResponse2<LienzoModelo>>,
                        response: Response<GeneralResponse2<LienzoModelo>>
                    ) {
                        if (response.isSuccessful){
                            val lienzo = response.body()?.data
                            lista[0].answer = lienzo?.a.toString()
                            lista[1].answer = lienzo?.b.toString()
                            lista[2].answer = lienzo?.c.toString()
                            lista[3].answer = lienzo?.d.toString()
                            lista[4].answer = lienzo?.e.toString()
                            lista[5].answer = lienzo?.f.toString()
                            lista[6].answer = lienzo?.g.toString()
                            lista[7].answer = lienzo?.h.toString()
                            lista[8].answer = lienzo?.i.toString()
                            lista[9].answer = lienzo?.j.toString()
                            lista[10].answer = lienzo?.k.toString()
                            lista[11].answer = lienzo?.l.toString()
                            lista[12].answer = lienzo?.m.toString()
                            lista[13].answer = lienzo?.n.toString()
                        }
                    }

                    override fun onFailure(
                        call: Call<GeneralResponse2<LienzoModelo>>,
                        t: Throwable
                    ) {
                        println("Error : ${t.message}")
                    }
                })
            1-> open.getDataFromLienzoVision(getAuthHeader(),s).enqueue(object : Callback<GeneralResponse2<LienzoVision>>{
                override fun onResponse(
                    call: Call<GeneralResponse2<LienzoVision>>,
                    response: Response<GeneralResponse2<LienzoVision>>
                ) {
                    if (response.isSuccessful){
                        val lienzo = response.body()?.data
                        lista[0].answer = lienzo?.a.toString()
                        lista[1].answer = lienzo?.b.toString()
                        lista[2].answer = lienzo?.c.toString()
                        lista[3].answer = lienzo?.d.toString()
                        lista[4].answer = lienzo?.e.toString()
                    }
                }

                override fun onFailure(call: Call<GeneralResponse2<LienzoVision>>, t: Throwable) {
                    println("Error : ${t.message}")
                }
            })

            2-> //Falta implementar
                return
            3->open.getDataFromLienzoPropuesta(getAuthHeader(),s).enqueue(object :Callback<GeneralResponse2<LienzoPropuesta>>{
                override fun onResponse(
                    call: Call<GeneralResponse2<LienzoPropuesta>>,
                    response: Response<GeneralResponse2<LienzoPropuesta>>
                ) {
                    if (response.isSuccessful){
                        val lienzo = response.body()?.data
                        lista[0].answer = lienzo?.a.toString()
                        lista[1].answer = lienzo?.b.toString()
                        lista[2].answer = lienzo?.c.toString()
                        lista[3].answer = lienzo?.d.toString()
                        lista[4].answer = lienzo?.e.toString()
                        lista[5].answer = lienzo?.f.toString()
                    }
                }

                override fun onFailure(
                    call: Call<GeneralResponse2<LienzoPropuesta>>,
                    t: Throwable
                ) {
                    println("Error : ${t.message}")
                }
            })
            4->open.getDataFromLienzoLean(getAuthHeader(),s).enqueue(object : Callback<GeneralResponse2<LienzoLean>>{
                override fun onResponse(
                    call: Call<GeneralResponse2<LienzoLean>>,
                    response: Response<GeneralResponse2<LienzoLean>>
                ) {
                    if (response.isSuccessful){
                        val lienzo = response.body()?.data
                        lista[0].answer = lienzo?.a.toString()
                        lista[1].answer = lienzo?.b.toString()
                        lista[2].answer = lienzo?.c.toString()
                        lista[3].answer = lienzo?.d.toString()
                        lista[4].answer = lienzo?.e.toString()
                        lista[5].answer = lienzo?.f.toString()
                        lista[6].answer = lienzo?.g.toString()
                        lista[7].answer = lienzo?.h.toString()
                        lista[8].answer = lienzo?.i.toString()
                    }
                }

                override fun onFailure(call: Call<GeneralResponse2<LienzoLean>>, t: Throwable) {
                    println("Error : ${t.message}")
                }
            })
        }

        if (position == lista.size - 1) {
            holder.binding.ln.visibility = View.VISIBLE
            holder.binding.guardarCambios.setOnClickListener {
                when (pdf) {
                    0 -> editPDF.editPDFLienzoModelo(v,
                        project_id, lista[0].answer, lista[1].answer,
                        lista[2].answer, lista[3].answer, lista[4].answer,
                        lista[5].answer, lista[6].answer, lista[7].answer,
                        lista[8].answer, lista[9].answer, lista[10].answer,
                        lista[11].answer, lista[12].answer, lista[13].answer
                    ) {
                        if (it) {
                            Toast.makeText(
                                view.context,
                                "PDF editado correctamente",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Toast.makeText(
                                view.context,
                                "Hubo algún problema con la edición",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    1 -> editPDF.editPDFLienzoVision(v,
                        project_id, lista[0].answer, lista[1].answer,
                        lista[2].answer, lista[3].answer, lista[4].answer,
                        null, null, null,
                        null, null, null,
                        null, null, null
                    ) {
                        if (it) {
                            Toast.makeText(
                                view.context,
                                "PDF editado correctamente",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Toast.makeText(
                                view.context,
                                "Hubo algún problema con la edición",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    2 ->//falta especificar
                        editPDF.editPDFLienzoValidacion(v,
                            project_id, lista[0].answer, lista[1].answer,
                            lista[2].answer, lista[3].answer, null,
                            null, null, null,
                            null, null, null,
                            null, null, null
                        ) {
                            if (it) {
                                Toast.makeText(
                                    view.context,
                                    "PDF editado correctamente",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                Toast.makeText(
                                    view.context,
                                    "Hubo algún problema con la edición",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                    3 -> editPDF.editPDFLienzoPropuesta(v,
                        project_id, lista[0].answer, lista[1].answer,
                        lista[2].answer, lista[3].answer, lista[4].answer,
                        lista[5].answer, null, null,
                        null, null, null,
                        null, null, null
                    ) {
                        if (it) {
                            Toast.makeText(
                                view.context,
                                "PDF editado correctamente",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Toast.makeText(
                                view.context,
                                "Hubo algún problema con la edición",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    4 -> editPDF.editPDFLienzoLeanProject(v,
                        project_id, lista[0].answer, lista[1].answer,
                        lista[2].answer, lista[3].answer, lista[4].answer,
                        lista[5].answer, lista[6].answer, lista[7].answer,
                        lista[8].answer, null, null,
                        null, null, null
                    ) {
                        if (it) {
                            Toast.makeText(
                                view.context,
                                "PDF editado correctamente",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Toast.makeText(
                                view.context,
                                "Hubo algún problema con la edición",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }


            }
        }

        holder.binding.btnRespuesta.setOnClickListener {
            showAlertDialog(lista, holder.binding.enuncioado.text.toString(), position)
        }
        setAnimation(holder.itemView, position)
        holder.binding.mainContainer.visibility =
            if (lista[position].isExpandable()) View.VISIBLE else View.GONE

        holder.binding.downLetAnswer.setOnClickListener {
            isAnyItemExpanded(holder.bindingAdapterPosition)
            lista[position].setExpandable(!lista[position].isExpandable())
            notifyItemChanged(holder.bindingAdapterPosition)
        }

    }

    override fun getItemCount(): Int = lista.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = GoalLienzoAdapterBinding.bind(view)

        fun bind(list: Statement) {
            with(binding) {
                enuncioado.text = list.statement
                if (list.answer == "null"){
                    contenedorRespuesta.text = ""
                }else
                {
                    contenedorRespuesta.text = list.answer
                }

            }
        }
    }

    private fun showAlertDialog(lista: List<Statement>, statement: String, position: Int) {
        val builder = AlertDialog.Builder(view.context)
        val input = EditText(view.context)
        input.hint = "Respuesta"
        builder.setView(input)
        builder.setTitle("Alert")
            .setMessage(statement)
            .setView(input)
            .setPositiveButton("Aceptar") { dialog, _ ->
                val respuesta = input.text.toString().trim()
                lista[position].answer = respuesta
                notifyItemChanged(position)
                dialog.dismiss()
            }
            .setNegativeButton("Cancelar") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
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