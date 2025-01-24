package com.shackleton.shape.db.laravel.controller

import android.widget.FrameLayout
import androidx.navigation.findNavController
import com.shackleton.shape.shared.SharedApp
import com.shackleton.shape.db.laravel.request.openConnection
import com.shackleton.shape.db.laravel.request.openConnectionWithAuth
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
    fun login(email: String, password: String, callback: () -> Unit) {
        openConnection()
            .create(UserApi::class.java).login(
            email,
            password
        ).enqueue(object : Callback<GeneralResponse> {
            override fun onResponse(call: Call<GeneralResponse>, response: Response<GeneralResponse>) {
                if (response.isSuccessful) {
                    val sessionResponse = response.body()
                        SharedApp.preferences.session = sessionResponse?.access_token!!
                        SharedApp.preferences.user = sessionResponse.user
                        callback()
                } else {
                    println("Error 1: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<GeneralResponse>, t: Throwable) {
                println("Error: ${t.message}")
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
                response.body().let { body ->
                    if(response.isSuccessful){
                        if (body != null) {
                            SharedApp.preferences.session = body.access_token
                            //SharedApp.preferences.user = body.user
                        }
                        root.findNavController().navigate(SignInFragmentDirections.actionSignInToFinishRegisterFragment())
                    }
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
