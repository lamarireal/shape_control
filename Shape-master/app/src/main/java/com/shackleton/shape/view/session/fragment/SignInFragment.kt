package com.shackleton.shape.view.session.fragment

import android.R
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.shackleton.shape.db.laravel.controller.UserController
import com.shackleton.shape.databinding.FragmentSignInBinding


class SignInFragment : Fragment() {

    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!

    private val userController = UserController()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)

        setSpinner()

        binding.registerBtnEnter.setOnClickListener {
            val name = binding.registerEditTextName.text.toString().trim()
            val nick = binding.registerEditTextNick.text.toString().trim()
            val email = binding.registerEditTextEmail.text.toString().trim()
            val password = binding.registerEditTextPassword.text.toString()
            val cPassword = binding.registerEditTextPasswordConfirm.text.toString()

            if (name.isNotEmpty() && nick.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && cPassword.isNotEmpty()) {
                Toast.makeText(requireContext(), "Revise su email para la verificacion", Toast.LENGTH_SHORT).show()

                userController.registerUser(name, nick, email, password, cPassword, binding.root) { errorMessage ->
                    Log.e("RegisterError", "Error al registrar usuario: $errorMessage")
                    Toast.makeText(requireContext(), "Error al registrar usuario", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }
    private fun setSpinner(){
        val spinnerItems = arrayOf("¿En qué etapa estàs?", "Aún no tengo una idea ", "Tengo una idea", "Mi idea esta en marcha")
        val adapter = ArrayAdapter(requireContext(), R.layout.simple_spinner_item, spinnerItems)
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        binding.optionsSpinner.adapter = adapter
    }


}