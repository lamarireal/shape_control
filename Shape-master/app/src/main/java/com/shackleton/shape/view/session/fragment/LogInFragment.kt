package com.shackleton.shape.view.session.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.shackleton.shape.db.laravel.controller.UserController
import com.shackleton.shape.databinding.FragmentLogInBinding


class LogInFragment : Fragment() {

    private var _binding: FragmentLogInBinding? = null
    private val binding get() = _binding!!

    private val userController = UserController()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLogInBinding.inflate(inflater, container, false)

        binding.loginBtnEnter.setOnClickListener {
            val email = binding.loginEditTextEmail.text.toString()
            val password = binding.loginEditTextPassword.text.toString()
            userController.login(email, password) {
                    findNavController().navigate(LogInFragmentDirections.actionLogInToMainHome())
            }
        }

        binding.loginTextViewResetPassword.setOnClickListener{
            findNavController().navigate(LogInFragmentDirections.actionLogInToForgotPasswordActivity())
        }


        binding.arrowBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()  // Vuelve a la pantalla anterior
        }





        return binding.root
    }





}