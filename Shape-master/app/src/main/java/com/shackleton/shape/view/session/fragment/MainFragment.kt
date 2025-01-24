package com.shackleton.shape.view.session.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.shackleton.shape.databinding.FragmentMainBinding
import com.shackleton.shape.shared.SharedApp

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        if (SharedApp.preferences.user.id != -1){
            requireActivity().finish()
            findNavController().navigate(MainFragmentDirections.actionMain2ToMainHome())
        }

        binding.btnLogin.setOnClickListener{
            findNavController().navigate(
                MainFragmentDirections.actionMain2ToLogIn()
            )
        }

        binding.btnCreateAccount.setOnClickListener {
            findNavController().navigate(
                MainFragmentDirections.actionMain2ToSignIn()
            )
        }

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}