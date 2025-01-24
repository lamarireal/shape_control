package com.shackleton.shape.db.laravel.request.service

import com.shackleton.shape.custom.adapter.CommentS
import com.shackleton.shape.db.laravel.model.Comment
import com.shackleton.shape.db.laravel.model.Post
import com.shackleton.shape.db.laravel.request.response.GeneralListResponse
import com.shackleton.shape.db.laravel.request.response.GeneralResponse
import com.shackleton.shape.db.laravel.request.response.GeneralResponse2
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import java.io.File

interface PostAPI {
    @Multipart
    @POST("api/upload_post")
    fun uploadPost(
        @Part("name")  name: RequestBody,
        @Part("descripcion")  descripcion: RequestBody,
        @Part image: MultipartBody.Part?
    ): Call<GeneralResponse>

    @GET("api/getAllPost")
    fun getAllPost(@Header("Authorization") token: String) : Call<GeneralListResponse<Post>>

    @FormUrlEncoded
    @POST("api/getPostsFromUser")
    fun getPostsFromUser(@Header("Authorization") token: String,@Field("id") id : Int) : Call<GeneralListResponse<Post>>

    @FormUrlEncoded
    @POST("api/getComments")
    fun getComments(@Header("Authorization") token: String,@Field("post") post : Int) : Call<GeneralListResponse<Comment>>

    @FormUrlEncoded
    @POST("api/uploadComment")
    fun uploadComment(@Header("Authorization") token: String,@Field("post") post : Int,@Field("comment") comment: String) : Call<GeneralResponse2<CommentS>>

}