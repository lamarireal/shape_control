package com.shackleton.shape.view.session.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.shackleton.shape.databinding.FragmentFinishRegisterBinding
import com.shackleton.shape.db.laravel.request.getAuthHeader
import com.shackleton.shape.db.laravel.request.openConnection
import com.shackleton.shape.db.laravel.request.response.GeneralResponse
import com.shackleton.shape.db.laravel.request.service.UserApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FinishRegisterViewModel : ViewModel() {
    private val _response = MutableLiveData<Boolean>()
    val response: LiveData<Boolean> get() = _response

    fun finishRegister(code: String) {
        openConnection().create(UserApi::class.java)
            .finishRegister(getAuthHeader(), code)
            .enqueue(object : Callback<GeneralResponse> {
                override fun onResponse(call: Call<GeneralResponse>, response: Response<GeneralResponse>) {
                    _response.value = response.isSuccessful
                }

                override fun onFailure(call: Call<GeneralResponse>, t: Throwable) {
                    _response.value = false
                }
            })
    }
}

class FinishRegisterFragment : Fragment() {

    private var _binding: FragmentFinishRegisterBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: FinishRegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFinishRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[FinishRegisterViewModel::class.java]

        viewModel.response.observe(viewLifecycleOwner) { isSuccess ->
            binding.progressBar.visibility = View.GONE
            binding.registerBtnEnter.isEnabled = true
            if (isSuccess) {
                Toast.makeText(requireContext(), "Success!", Toast.LENGTH_SHORT).show()
                findNavController().navigate(FinishRegisterFragmentDirections.actionFinishRegisterFragmentToLogIn())
            } else {
                Toast.makeText(requireContext(), "Error!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.arrowBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        binding.terms.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("Términos y condiciones")
            builder.setMessage("Aquí должны быть реальные условия использования.")
            builder.setPositiveButton("OK", null)
            val dialog = builder.create()
            dialog.show()
        }

        binding.registerBtnEnter.setOnClickListener {
            val code = binding.codigo.text.toString().trim()
            if (code.isEmpty()) {
                Toast.makeText(requireContext(), "Enter the code", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            binding.progressBar.visibility = View.VISIBLE
            binding.registerBtnEnter.isEnabled = false
            viewModel.finishRegister(code)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
