package com.shackleton.shape.view.home.fragment.homeActivityNav.fragmentEvaluaNav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.shackleton.shape.R

class EvaluaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_evalua3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val botonEnviar = view.findViewById<Button>(R.id.botonEnviar)

        botonEnviar.setOnClickListener {
            Toast.makeText(requireContext(), "¡Gracias por compartir tu opinión!", Toast.LENGTH_SHORT).show()
            requireActivity().finish()
        }
    }
}
