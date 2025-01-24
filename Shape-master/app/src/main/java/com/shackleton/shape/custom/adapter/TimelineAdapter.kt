package com.shackleton.shape.custom.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.shackleton.shape.R
import com.shackleton.shape.databinding.TimelineAdapterBinding
import com.shackleton.shape.view.home.fragment.homeActivityNav.fragmentProjectNav.TimelineFragment
import com.shackleton.shape.view.home.fragment.homeActivityNav.fragmentProjectNav.TimelineFragmentDirections

class TimelineAdapter(
    var lista: List<TimelineFragment.CanvasData>,
    private val requireActivity: FrameLayout,
    private val idP: String,
    private val nameP: String
): RecyclerView.Adapter<TimelineAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.timeline_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(position == 0){
            holder.binding.contL.visibility= View.GONE
        }
        holder.bind(lista[position],requireActivity,position,idP,nameP)
    }

    override fun getItemCount(): Int = lista.size

    class ViewHolder (view: View): RecyclerView.ViewHolder(view) {
        val binding = TimelineAdapterBinding.bind(view)
        fun bind (
            list: TimelineFragment.CanvasData,
            requireActivity: FrameLayout,
            position: Int,
            idP: String,
            nameP: String
        ){
            with(binding){
                name.text = list.name
                completado.text = list.completado
                editPDF.setOnClickListener {
                    val arr = arrayOf(nameP,list.name,position.toString(),idP)
                    Navigation.findNavController(requireActivity).navigate(TimelineFragmentDirections.actionTimelineFragment2ToLienzoSelectedFragment3(parameters = arr ))
                }
            }
        }
    }
}