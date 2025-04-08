package com.shackleton.shape.view.home.fragment.homeFragmentNav

import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.shackleton.shape.R
import com.shackleton.shape.app_permissions.PermissionHandler
import com.shackleton.shape.db.laravel.controller.PostController
import com.shackleton.shape.databinding.FragmentEvaluaMainBinding
import com.shackleton.shape.view.Path22
import com.squareup.picasso.Picasso
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import java.io.FileOutputStream

class EvaluaMainFragment : Fragment() {


    private lateinit var permissionHandler: PermissionHandler

    private var _binding: FragmentEvaluaMainBinding? = null
    private val binding get() = _binding!!

    private val postController = PostController()

    private val pth = Path22()

    var path : String = ""

    private lateinit var pickMedia: ActivityResultLauncher<PickVisualMediaRequest>


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        permissionHandler = PermissionHandler(requireContext())

        pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { result ->
            if (result != null) {
                binding.imageButton.setImageURI(result)
                path = pth.getRealPath(requireContext(), result)!!

            } else {
                Toast.makeText(requireContext(), "Selecciona una imagen", Toast.LENGTH_LONG).show()
            }
        }

        binding.imageButton.setOnClickListener {
            permissionSetup()
        }

        binding.btnUploadPost.setOnClickListener {

            with(binding) {
                if (editTextNombreProyecto.text.isNotEmpty() && editTextIdea.text.isNotEmpty()) {
                    if (path.isNotEmpty()){
                        val file = File(path)
                        val nFile = resizeImage(file)
                        val dFile = saveBitmapToFile(nFile!!)
                        val rFile = RequestBody.create(MediaType.parse("multipart/form-data"), dFile)
                        val body = MultipartBody.Part.createFormData("image", dFile.name, rFile)

                        val name = RequestBody.create(MediaType.parse("multipart/form-data"), editTextNombreProyecto.text.toString())
                        val desc = RequestBody.create(MediaType.parse("multipart/form-data"), editTextIdea.text.toString())


                        uploadPostWithImage(name,desc,body)
                    }
                    else
                    {
                        val name = RequestBody.create(MediaType.parse("multipart/form-data"), editTextNombreProyecto.text.toString())
                        val desc = RequestBody.create(MediaType.parse("multipart/form-data"), editTextIdea.text.toString())
                        uploadPostWithImage(name,desc,null)
                    }
                }else{
                    Toast.makeText(requireContext(), "Rellena los campos necesarios", Toast.LENGTH_LONG).show()
                }
            }

        }
    }

    private fun uploadPostWithImage(proyect: RequestBody, idea: RequestBody, image : MultipartBody.Part?){
        postController.uploadPost(proyect, idea, image) { success ->
            if (success) {
                Toast.makeText(requireContext(), "Post subido correctamente", Toast.LENGTH_LONG).show()
                view?.post {
                    findNavController().navigate(R.id.action_evaluaMainFragment_to_evaluaFragment)
                }
            } else {
                Toast.makeText(requireContext(), "Hubo un problema al subir el post", Toast.LENGTH_LONG).show()
            }
        }
    }


    private fun saveBitmapToFile(bitmap: Bitmap): File {
        val file = File.createTempFile("image", ".jpg", requireContext().externalCacheDir)

        FileOutputStream(file).use { outputStream ->
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, outputStream)
        }

        return file
    }

    private fun resizeImage(file: File): Bitmap? {
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeFile(file.absolutePath, options)
        val scale = calculateImageScale(options.outWidth, options.outHeight)
        options.inJustDecodeBounds = false
        options.inSampleSize = scale
        return BitmapFactory.decodeFile(file.absolutePath, options)
    }

    private fun calculateImageScale(width: Int, height: Int): Int {
        val targetWidth = 2048
        val targetHeight = 2048
        var scale = 1

        if (width > targetWidth || height > targetHeight) {
            val scaleX = width.toFloat() / targetWidth.toFloat()
            val scaleY = height.toFloat() / targetHeight.toFloat()
            scale = Math.max(scaleX, scaleY).toInt()
        }

        return scale
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEvaluaMainBinding.inflate(inflater, container, false)

        permissionHandler = PermissionHandler(requireContext())

        Picasso.get()
            .load("https://images.unsplash.com/photo-1605882174908-4bfbb907e3cd?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHwxNHx8cGhvdG8lMjBpY29ufGVufDF8fHx8MTY3ODcxODA1MA&ixlib=rb-4.0.3&q=80&w=1080")
            .into(binding.imageButton)

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
            Toast.makeText(requireContext(), "Permission denied", Toast.LENGTH_SHORT).show()
        }
    }

    private fun permissionSetup(){
        if (Build.VERSION.SDK_INT >= 33) {
            val readPermission = ContextCompat.checkSelfPermission(
                requireContext(), android.Manifest.permission.READ_MEDIA_IMAGES
            )
            if (readPermission != PackageManager.PERMISSION_GRANTED) {
                permissionsResultCallback.launch(android.Manifest.permission.READ_MEDIA_IMAGES)
            } else {
                println("Permissions areGranted")
                doOperation()
            }
        }
    }


}