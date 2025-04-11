package com.shackleton.shape.view.home.fragment

import android.app.AlertDialog
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.shackleton.shape.custom.adapter.PostAdapter
import com.shackleton.shape.db.laravel.controller.UserController
import com.shackleton.shape.databinding.FragmentProfileBinding
import com.shackleton.shape.db.laravel.model.Post
import com.shackleton.shape.db.laravel.model.User
import com.shackleton.shape.db.laravel.request.getAuthHeader
import com.shackleton.shape.db.laravel.request.openConnection
import com.shackleton.shape.db.laravel.request.response.GeneralListResponse
import com.shackleton.shape.db.laravel.request.response.GeneralResponse
import com.shackleton.shape.db.laravel.request.response.GeneralResponse2
import com.shackleton.shape.db.laravel.request.service.PostAPI
import com.shackleton.shape.db.laravel.request.service.UserApi
import com.shackleton.shape.shared.SharedApp
import com.shackleton.shape.view.Path22
import com.shackleton.shape.view.home.MainHome
import com.squareup.picasso.Picasso
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    private val binding get() = _binding!!

    private val pth = Path22()

    var path: String = ""

    private val userController = UserController()

    private lateinit var pickMedia: ActivityResultLauncher<PickVisualMediaRequest>


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        openConnection().create(PostAPI::class.java)
            .getPostsFromUser(getAuthHeader(), SharedApp.preferences.user.id)
            .enqueue(object : Callback<GeneralListResponse<Post>> {
                override fun onResponse(
                    call: Call<GeneralListResponse<Post>>,
                    response: Response<GeneralListResponse<Post>>
                ) {
                    if (response.isSuccessful) {
                        binding.postsUser.adapter =
                            response.body()?.data?.let { PostAdapter(it, binding.root) }
                    }
                }

                override fun onFailure(call: Call<GeneralListResponse<Post>>, t: Throwable) {
                    println("Error : ${t.message}")
                }
            })
    }

    private fun botonConfiguracion() {
        binding.btnConfiguracion.setOnClickListener {
            if (binding.linearDatos.visibility == View.VISIBLE) {
                binding.linearDatos.visibility = View.GONE
                binding.linearConfiguracion.visibility = View.VISIBLE
            } else {
                binding.linearDatos.visibility = View.VISIBLE
                binding.linearConfiguracion.visibility = View.GONE
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        (activity as? MainHome)?.setBottomNavigationVisibility(View.VISIBLE)
        openConnection().create(UserApi::class.java).getUserByNick(SharedApp.preferences.user.nick)
            .enqueue(object :Callback<GeneralResponse2<User>>{
                override fun onResponse(
                    call: Call<GeneralResponse2<User>>,
                    response: Response<GeneralResponse2<User>>
                ) {
                   if (response.isSuccessful){
                       binding.numeroSeguidores.text = response.body()?.data?.followers_count.toString()
                       Picasso.get().load(response.body()?.data?.user_image_url).into(binding.imagenPerfil)
                       SharedApp.preferences.user = response.body()?.data!!
                   }
                }

                override fun onFailure(call: Call<GeneralResponse2<User>>, t: Throwable) {
                    println("Error: ${t.message}")
                }
            })

        botonConfiguracion()

        binding.titleName.text = SharedApp.preferences.user.full_name
        binding.titleUserNick.text = SharedApp.preferences.user.nick

        pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { result ->
            if (result != null) {
                binding.imagenPerfil.setImageURI(result)
                path = pth.getRealPath(requireContext(), result)!!
                val file = File(path)
                val rFile = RequestBody.create(MediaType.parse("nultipart/form-data"), file)
                val body = MultipartBody.Part.createFormData("image", file.name, rFile)
                userController.uploadImageProfile(body)
            } else {
                Toast.makeText(requireContext(), "Selecciona una imagen", Toast.LENGTH_LONG).show()
            }
        }

        binding.changePassword.setOnClickListener {
            findNavController().navigate(ProfileFragmentDirections.actionProfileFragment4ToChangePasswordActivity())
        }




        binding.changeFullName.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("Cambiar nombre")


            val input = EditText(requireContext())
            input.hint = "Nuevo nombre"
            builder.setView(input)

            builder.setPositiveButton("Aceptar") { dialog, _ ->
                val newName = input.text.toString()
                openConnection().create(UserApi::class.java).update_full_name(getAuthHeader(),newName)
                    .enqueue(object : Callback<GeneralResponse>{
                        override fun onResponse(
                            call: Call<GeneralResponse>,
                            response: Response<GeneralResponse>
                        ) {
                            if (response.isSuccessful){
                                binding.titleName.text = response.body()?.data!!
                                SharedApp.preferences.user.full_name =  response.body()?.data!!
                                Toast.makeText(requireContext(),"Nombre Cambiado", Toast.LENGTH_SHORT).show()
                            }
                        }

                        override fun onFailure(call: Call<GeneralResponse>, t: Throwable) {
                            TODO("Not yet implemented")
                        }
                    })
                dialog.dismiss()
            }

            builder.setNegativeButton("Cancelar") { dialog, _ ->
                dialog.cancel()
            }

            builder.show()
        }

        binding.changeImageProfile.setOnClickListener {
            permissionSetup()
        }

        return binding.root
    }

    private fun doOperation() {
        pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
    }

    private val permissionsResultCallback = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            permissionSetup()
        } else {
            Toast.makeText(requireContext(), "Permisos denegados", Toast.LENGTH_SHORT).show()
        }
    }

    private fun permissionSetup() {
        if (Build.VERSION.SDK_INT >= 33) {
            val readPermission = ContextCompat.checkSelfPermission(
                requireContext(), android.Manifest.permission.READ_MEDIA_IMAGES
            )
            if (readPermission != PackageManager.PERMISSION_GRANTED) {
                permissionsResultCallback.launch(android.Manifest.permission.READ_MEDIA_IMAGES)
            } else {
                doOperation()
            }
        }
    }



}