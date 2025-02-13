package com.shackleton.shape.db.laravel.request.service

import com.shackleton.shape.db.laravel.model.User
import com.shackleton.shape.db.laravel.request.response.CheckResponse
import com.shackleton.shape.db.laravel.request.response.GeneralListResponse
import com.shackleton.shape.db.laravel.request.response.GeneralListResponse2
import com.shackleton.shape.db.laravel.request.response.GeneralResponse
import com.shackleton.shape.db.laravel.request.response.GeneralResponse2
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface UserApi {
    /**
     * API call to POST api/login.
     * Validates user
     *
     * @param [email] email of the user
     * @param [password] password associated with that email
     *
     * @return [GeneralResponse] result of the operation, if successfully returns session token
     */
    @FormUrlEncoded
    @POST("api/login")
    fun login(@Field("email") email: String, @Field("password") password: String, ) : Call<GeneralResponse>

    /**
     * API call to POST api/register.
     * Creates new user
     *
     * @param [name]
     * @param [lastName]
     * @param [email]
     * @param [password]
     * @param [cPassword]
     *
     * @return [GeneralResponse] result of the operation, if successfully returns session token
     */
    @FormUrlEncoded
    @POST("api/register")
    fun register(
        @Field("full_name") name: String,
        @Field("nick") nick: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("password_confirmation") password_confirmation: String,
    ) : Call<GeneralResponse>

    @FormUrlEncoded
    @POST("api/checkNickAndEmail")
    fun checkNickAndEmail(
        @Field("nick") nick: String,
        @Field("email") email: String
    ): Call<CheckResponse>

    @FormUrlEncoded
    @POST("api/update_full_name")
    fun update_full_name(
        @Header("Authorization") token: String,@Field("full_name") name: String,
    ) : Call<GeneralResponse>


    @Multipart
    @POST("api/upload-image")
    fun uploadImageProfile(
        @Part image: MultipartBody.Part?
    ): Call<GeneralResponse>

    @GET("api/getAllUsers")
    fun getAllUsers(
    ): Call<GeneralListResponse2<User>>

    @FormUrlEncoded
    @POST("api/getUserByNick")
    fun getUserByNick(@Field("nick") nick : String
    ): Call<GeneralResponse2<User>>

    @FormUrlEncoded
    @POST("api/follow")
    fun follow(
        @Header("Authorization") token: String,
        @Field("id") id: Int,
    ) : Call<GeneralResponse>

    @FormUrlEncoded
    @POST("api/unfollow")
    fun unfollow(
        @Header("Authorization") token: String,
        @Field("id") id: Int,
    ) : Call<GeneralResponse>

    @FormUrlEncoded
    @POST("api/isFollowing1")
    fun isFollowing1(
        @Header("Authorization") token: String,
        @Field("idS") id: Int,
    ) : Call<GeneralResponse>


    @FormUrlEncoded
    @POST("api/finishRegister")
    fun finishRegister(
        @Header("Authorization") token: String,
        @Field("codigo") codigo: String
    ) : Call<GeneralResponse>
    @FormUrlEncoded
    @POST("api/forgotPassword")
    fun forgotPassword(
        @Field("email") email: String
    ) : Call<GeneralResponse>

}