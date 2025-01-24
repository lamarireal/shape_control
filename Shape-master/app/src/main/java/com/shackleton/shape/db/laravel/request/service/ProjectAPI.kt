package com.shackleton.shape.db.laravel.request.service

import com.shackleton.shape.db.laravel.model.Proyecto
import com.shackleton.shape.db.laravel.request.response.GeneralResponse2
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ProjectAPI {
    @GET("api/getProjects")
    fun getProjects(@Header("Authorization") token: String) : Call<List<Proyecto>>

    @FormUrlEncoded
    @POST("api/storeProject")
    fun createProject(@Header("Authorization") token: String,@Field("name") name : String,@Field("description") description : String) : Call<GeneralResponse2<Proyecto>>
}