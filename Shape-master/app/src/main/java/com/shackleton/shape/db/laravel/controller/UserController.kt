package com.shackleton.shape.db.laravel.controller

import android.widget.FrameLayout
import android.widget.Toast
import androidx.navigation.findNavController
import com.shackleton.shape.shared.SharedApp
import com.shackleton.shape.db.laravel.request.openConnection
import com.shackleton.shape.db.laravel.request.openConnectionWithAuth
import com.shackleton.shape.db.laravel.request.response.CheckResponse
import com.shackleton.shape.db.laravel.request.response.GeneralResponse
import com.shackleton.shape.db.laravel.request.service.UserApi
import com.shackleton.shape.view.session.fragment.FinishRegisterFragmentDirections
import com.shackleton.shape.view.session.fragment.LogInFragmentDirections
import com.shackleton.shape.view.session.fragment.SignInFragmentDirections
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserController {
    fun login(email: String, password: String, callback: () -> Unit, errorCallback: (String) -> Unit) {
        if (email.isEmpty() || password.isEmpty()) {
            errorCallback("Por favor, complete todos los campos")
            return
        }

        openConnection()
            .create(UserApi::class.java).login(email, password)
            .enqueue(object : Callback<GeneralResponse> {
                override fun onResponse(call: Call<GeneralResponse>, response: Response<GeneralResponse>) {
                    if (response.isSuccessful) {
                        val sessionResponse = response.body()
                        if (sessionResponse != null && sessionResponse.access_token != null) {
                            SharedApp.preferences.session = sessionResponse.access_token
                            SharedApp.preferences.user = sessionResponse.user
                            callback()
                        } else {
                            errorCallback("Respuesta del servidor no válida")
                        }
                    } else {
                        val errorBody = response.errorBody()?.string() ?: "No se pudo obtener el mensaje de error"
                        errorCallback("Error en la autenticación: $errorBody")
                        println(errorBody)
                    }
                }

                override fun onFailure(call: Call<GeneralResponse>, t: Throwable) {
                    errorCallback("Error de conexión: ${t.message}")
                }
            })
    }

    fun registerUser(
        name: String,
        nick: String,
        email: String,
        password: String,
        password_confirmation: String,
        root: FrameLayout
    ) {
        openConnection()
            .create(UserApi::class.java).register(
                name,
                nick,
                email,
                password,
                password_confirmation
            ).enqueue(object : Callback<GeneralResponse> {
                override fun onResponse(call: Call<GeneralResponse>, response: Response<GeneralResponse>) {
                    if (response.isSuccessful) {
                        val body = response.body()
                        if (body != null) {
                            SharedApp.preferences.session = body.access_token
                            root.findNavController().navigate(SignInFragmentDirections.actionSignInToFinishRegisterFragment())
                        } else {
                            Toast.makeText(root.context, "Respuesta del servidor vacía", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        val errorBody = response.errorBody()?.string()
                        Toast.makeText(root.context, "Error en el registro: ${response.code()} - $errorBody", Toast.LENGTH_LONG).show()
                        println("Registro fallido: ${response.code()} - $errorBody")
                    }
                }

                override fun onFailure(call: Call<GeneralResponse>, t: Throwable) {
                    println(t.message)
                }
            })

    }

    fun uploadImageProfile(imageFile: MultipartBody.Part) {
        openConnectionWithAuth()
            .create(UserApi::class.java).uploadImageProfile(imageFile)
            .enqueue(object : Callback<GeneralResponse> {
                override fun onResponse(
                    call: Call<GeneralResponse>,
                    response: Response<GeneralResponse>
                ) {
                    if (response.isSuccessful) {
                        val url = response.body()?.data
                        if (url != null) {
                            SharedApp.preferences.imageURL = url
                        } else {
                            SharedApp.preferences.imageURL = "dx"
                        }
                    } else {
                        SharedApp.preferences.imageURL = "dx"
                        println("Upload failed: ${response.code()} - ${response.message()}")
                    }
                }

                override fun onFailure(call: Call<GeneralResponse>, t: Throwable) {
                    println("Upload failed: ${t.message}")
                    SharedApp.preferences.imageURL = "dx"
                }
            })
    }}
