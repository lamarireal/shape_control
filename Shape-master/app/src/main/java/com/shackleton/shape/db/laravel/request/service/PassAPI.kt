package com.shackleton.shape.db.laravel.request.service

import com.shackleton.shape.db.laravel.request.response.GeneralResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface PassAPI {

    @FormUrlEncoded
    @POST("api/change_password")
    fun changepassword(@Header("Authorization") token: String, @Field("current_password") current_password  : String, @Field("password") password  : String ,@Field("password_confirmation") password_confirmation  : String ) : Call<GeneralResponse>
}