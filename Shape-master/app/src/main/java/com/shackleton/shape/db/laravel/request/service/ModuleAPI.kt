package com.shackleton.shape.db.laravel.request.service

import com.shackleton.shape.db.laravel.model.Module
import com.shackleton.shape.db.laravel.request.response.GeneralListResponse
import retrofit2.Call
import retrofit2.http.*

interface ModuleAPI {

    @GET("api/modules")
    fun getModuleList(@Header("Authorization") token: String, ) : Call<GeneralListResponse<Module>>

    @GET("api/users/{userId}/showSelected")
    fun showSelected(@Header("Authorization") token: String,@Path("userId") userId: Int): Call<GeneralListResponse<Module>>

}