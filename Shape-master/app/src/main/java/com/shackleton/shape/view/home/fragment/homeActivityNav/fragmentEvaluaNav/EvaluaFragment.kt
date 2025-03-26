package com.shackleton.shape.view.home.fragment.homeActivityNav.fragmentEvaluaNav

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.shackleton.shape.R
import com.shackleton.shape.view.home.MainHome

class EvaluaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_evalua3, container, false)

        // Referencia al botón
        val enviarButton = view.findViewById<Button>(R.id.button4)

        enviarButton.setOnClickListener {
            Toast.makeText(requireContext(), "Gracias por enviar tu retroalimentación", Toast.LENGTH_SHORT).show()

            //  Volver al menú principal (MainHome Activity)
            val intent = Intent(requireContext(), MainHome::class.java)
            startActivity(intent)
            requireActivity().finish()
        }

        return view
    }
}
