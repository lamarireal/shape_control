package com.shackleton.shape.custom.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.NestedScrollView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.shackleton.shape.R
import com.shackleton.shape.databinding.PreguntasAdapterBinding
import com.shackleton.shape.shared.SharedApp
import com.shackleton.shape.view.home.fragment.homeActivityNav.fragmentRetoNav.PreguntasFragment
import com.shackleton.shape.view.home.fragment.homeActivityNav.fragmentRetoNav.PreguntasFragmentDirections

class PreguntasAdapter(
    private var lista1: NestedScrollView,
    private var lista: List<PreguntasFragment.PreguntaClass>,
    private var i: Int,
    private var context: Context?
) :
    RecyclerView.Adapter<PreguntasAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.preguntas_adapter, parent, false)
        return ViewHolder(view)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(lista[position], position, lista)
        if (position == lista.size - 1) {
            holder.binding.button.visibility = View.VISIBLE

            holder.binding.button.setOnClickListener {
                when (i) {
                    1 ->
                        if (lista[0].respuestaSeleccionada == lista[0].respuesta3 &&
                            lista[1].respuestaSeleccionada == lista[1].respuesta2 &&
                            lista[2].respuestaSeleccionada == lista[2].respuesta2 &&
                            lista[3].respuestaSeleccionada == lista[3].respuesta2 &&
                            lista[4].respuestaSeleccionada == lista[4].respuesta1
                        ) {
                            SharedApp.preferences.libro1 = true
                            Toast.makeText(context,"Esta bien", Toast.LENGTH_SHORT).show()
                            Navigation.findNavController(lista1).navigate(PreguntasFragmentDirections.actionPreguntasFragmentToBibliotecaFragment2())
                        }else{
                            Toast.makeText(context,"No esta bien", Toast.LENGTH_SHORT).show()
                        }

                    2 -> if (lista[0].respuestaSeleccionada == lista[0].respuesta2 &&
                        lista[1].respuestaSeleccionada == lista[1].respuesta2 &&
                        lista[2].respuestaSeleccionada == lista[2].respuesta3 &&
                        lista[3].respuestaSeleccionada == lista[3].respuesta3 &&
                        lista[4].respuestaSeleccionada == lista[4].respuesta3
                    ) {
                        SharedApp.preferences.libro2 = true
                        Toast.makeText(context,"Esta bien", Toast.LENGTH_SHORT).show()
                        Navigation.findNavController(lista1).navigate(PreguntasFragmentDirections.actionPreguntasFragmentToBibliotecaFragment2())

                    }else{
                        Toast.makeText(context,"No esta bien", Toast.LENGTH_SHORT).show()
                    }

                    3 -> if (lista[0].respuestaSeleccionada == lista[0].respuesta3 &&
                        lista[1].respuestaSeleccionada == lista[1].respuesta2 &&
                        lista[2].respuestaSeleccionada == lista[2].respuesta3 &&
                        lista[3].respuestaSeleccionada == lista[3].respuesta3 &&
                        lista[4].respuestaSeleccionada == lista[4].respuesta3
                    ) {
                        SharedApp.preferences.libro3 = true
                        Toast.makeText(context,"Esta bien", Toast.LENGTH_SHORT).show()
                        Navigation.findNavController(lista1).navigate(PreguntasFragmentDirections.actionPreguntasFragmentToBibliotecaFragment2())

                    }else{
                        Toast.makeText(context,"No esta bien", Toast.LENGTH_SHORT).show()
                    }

                    4 -> if (lista[0].respuestaSeleccionada == lista[0].respuesta1 &&
                        lista[1].respuestaSeleccionada == lista[1].respuesta3 &&
                        lista[2].respuestaSeleccionada == lista[2].respuesta3 &&
                        lista[3].respuestaSeleccionada == lista[3].respuesta1 &&
                        lista[4].respuestaSeleccionada == lista[4].respuesta3
                    ) {
                        SharedApp.preferences.libro4 = true
                        Toast.makeText(context,"Esta bien", Toast.LENGTH_SHORT).show()
                        Navigation.findNavController(lista1).navigate(PreguntasFragmentDirections.actionPreguntasFragmentToBibliotecaFragment2())

                    }else{
                        Toast.makeText(context,"No esta bien", Toast.LENGTH_SHORT).show()
                    }

                    5 -> if (lista[0].respuestaSeleccionada == lista[0].respuesta2 &&
                        lista[1].respuestaSeleccionada == lista[1].respuesta1 &&
                        lista[2].respuestaSeleccionada == lista[2].respuesta1 &&
                        lista[3].respuestaSeleccionada == lista[3].respuesta3 &&
                        lista[4].respuestaSeleccionada == lista[4].respuesta1
                    ) {
                        SharedApp.preferences.libro5 = true
                        Toast.makeText(context,"Esta bien", Toast.LENGTH_SHORT).show()
                        Navigation.findNavController(lista1).navigate(PreguntasFragmentDirections.actionPreguntasFragmentToBibliotecaFragment2())

                    }
                    else{
                        Toast.makeText(context,"No esta bien", Toast.LENGTH_SHORT).show()
                    }

                    6 -> if (lista[0].respuestaSeleccionada == lista[0].respuesta1 &&
                        lista[1].respuestaSeleccionada == lista[1].respuesta1 &&
                        lista[2].respuestaSeleccionada == lista[2].respuesta3 &&
                        lista[3].respuestaSeleccionada == lista[3].respuesta3 &&
                        lista[4].respuestaSeleccionada == lista[4].respuesta1
                    ) {
                        SharedApp.preferences.libro6 = true
                        Toast.makeText(context,"Esta bien", Toast.LENGTH_SHORT).show()
                        Navigation.findNavController(lista1).navigate(PreguntasFragmentDirections.actionPreguntasFragmentToBibliotecaFragment2())

                    }else{
                        Toast.makeText(context,"No esta bien", Toast.LENGTH_SHORT).show()
                    }

                    7 -> if (lista[0].respuestaSeleccionada == lista[0].respuesta2 &&
                        lista[1].respuestaSeleccionada == lista[1].respuesta1 &&
                        lista[2].respuestaSeleccionada == lista[2].respuesta1 &&
                        lista[3].respuestaSeleccionada == lista[3].respuesta3 &&
                        lista[4].respuestaSeleccionada == lista[4].respuesta2
                    ) {
                        SharedApp.preferences.libro7 = true
                        Toast.makeText(context,"Esta bien", Toast.LENGTH_SHORT).show()
                        Navigation.findNavController(lista1).navigate(PreguntasFragmentDirections.actionPreguntasFragmentToBibliotecaFragment2())
                    }else{
                        Toast.makeText(context,"No esta bien", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }


    override fun getItemCount(): Int = lista.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = PreguntasAdapterBinding.bind(view)

        fun bind(
            item: PreguntasFragment.PreguntaClass,
            position: Int,
            lista: List<PreguntasFragment.PreguntaClass>,
        ) {
            with(binding) {
                questionTextView.text = item.pregunta
                answer1RadioButton.text = item.respuesta1
                answer2RadioButton.text = item.respuesta2
                answer3RadioButton.text = item.respuesta3

                answer1RadioButton.setOnCheckedChangeListener { _, isChecked ->
                    if (isChecked) {
                        lista[position].respuestaSeleccionada = item.respuesta1
                    }
                }
                answer2RadioButton.setOnCheckedChangeListener { _, isChecked ->
                    if (isChecked) {
                        lista[position].respuestaSeleccionada = item.respuesta2
                    }
                }
                answer3RadioButton.setOnCheckedChangeListener { _, isChecked ->
                    if (isChecked) {
                        lista[position].respuestaSeleccionada = item.respuesta3
                    }
                }
            }
        }
    }
}