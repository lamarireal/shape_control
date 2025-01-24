package com.shackleton.shape.view.session.fragment

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.shackleton.shape.databinding.FragmentFinishRegisterBinding
import com.shackleton.shape.db.laravel.controller.UserController
import com.shackleton.shape.db.laravel.request.getAuthHeader
import com.shackleton.shape.db.laravel.request.openConnection
import com.shackleton.shape.db.laravel.request.response.GeneralResponse
import com.shackleton.shape.db.laravel.request.service.UserApi
import com.shackleton.shape.view.home.fragment.homeFragmentNav.LienzosMainFragmentDirections
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FinishRegisterFragment : Fragment() {

    private var _binding: FragmentFinishRegisterBinding? = null

    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.terms.setOnClickListener {
            val builder = AlertDialog.Builder(view.context)
            builder.setTitle("Términos y condiciones")
            builder.setMessage("  ")
            val dialog = builder.create()
            dialog.show()
        }

        binding.registerBtnEnter.setOnClickListener {
            openConnection().create(UserApi::class.java)
                .finishRegister(getAuthHeader(), binding.codigo.text.toString())
                .enqueue(object : Callback<GeneralResponse> {
                    override fun onResponse(
                        call: Call<GeneralResponse>,
                        response: Response<GeneralResponse>
                    ) {
                        if (response.isSuccessful) {
                            Toast.makeText(
                                requireContext(),
                                "Ya puedes iniciar sesion",
                                Toast.LENGTH_SHORT
                            ).show()
                            findNavController().navigate(FinishRegisterFragmentDirections.actionFinishRegisterFragmentToLogIn())
                        }else{
                            println("Error 1 : ${response.code()}")
                            println("Error 1 : ${response.message()}")
                            Toast.makeText(
                                requireContext(),
                                "No coincide el código",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    override fun onFailure(call: Call<GeneralResponse>, t: Throwable) {
                        println("Error 2 : ${t.message}")
                    }
                })
        }



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFinishRegisterBinding.inflate(inflater, container, false)

        return binding.root
    }

}