package com.shackleton.shape.db.laravel.controller


import com.shackleton.shape.db.laravel.request.openConnectionWithAuth
import com.shackleton.shape.db.laravel.request.response.GeneralResponse
import com.shackleton.shape.db.laravel.request.service.PostAPI
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostController {

    fun uploadPost(
        name: RequestBody,
        descripcion: RequestBody,
        imageFile: MultipartBody.Part?,
        callback: (Boolean) -> Unit
    ) {

        openConnectionWithAuth()
            .create(PostAPI::class.java).uploadPost(
            name,descripcion,imageFile
        ).enqueue(object : Callback<GeneralResponse> {
            override fun onResponse(call: Call<GeneralResponse>, response: Response<GeneralResponse>) {
                if (response.isSuccessful) {
                    callback(true)
                } else {
                    println("Response not successful: ${response.code()}")
                    println("Response not successful: ${response.message()}")
                    callback(false)
                }
            }

            override fun onFailure(call: Call<GeneralResponse>, t: Throwable) {
                println("Error: ${t.message}")
                callback(false)
            }
        })


    }

    fun getAllPosts(callback: (List<com.shackleton.shape.db.laravel.model.Post>?) -> Unit){
        com.shackleton.shape.db.laravel.request.openConnection()
            .create(PostAPI::class.java).getAllPost(
                com.shackleton.shape.db.laravel.request.getAuthHeader()
            )
            .enqueue(object : Callback<com.shackleton.shape.db.laravel.request.response.GeneralListResponse<com.shackleton.shape.db.laravel.model.Post>>{
                override fun onResponse(
                    call: Call<com.shackleton.shape.db.laravel.request.response.GeneralListResponse<com.shackleton.shape.db.laravel.model.Post>>,
                    response: Response<com.shackleton.shape.db.laravel.request.response.GeneralListResponse<com.shackleton.shape.db.laravel.model.Post>>,
                ) {
                    if (response.isSuccessful){
                        println("good")
                        response.body()?.data?.let { callback(it) }
                    }else{
                        println("Response not successful: ${response.code()}")
                        callback(listOf())
                    }
                }

                override fun onFailure(call: Call<com.shackleton.shape.db.laravel.request.response.GeneralListResponse<com.shackleton.shape.db.laravel.model.Post>>, t: Throwable) {
                    println("Error: ${t.message}")
                    callback(null)
                }
            })
    }

    /*fun getAllPostsFromUser(callback: (List<com.shackleton.shape.db.laravel.model.Post>?) -> Unit){
        com.shackleton.shape.db.laravel.request.openConnection()
            .create(PostAPI::class.java).getPostsFromUser(
                com.shackleton.shape.db.laravel.request.getAuthHeader()
        )
            .enqueue(object : Callback<com.shackleton.shape.db.laravel.request.response.GeneralListResponse<com.shackleton.shape.db.laravel.model.Post>>{
                override fun onResponse(
                    call: Call<com.shackleton.shape.db.laravel.request.response.GeneralListResponse<com.shackleton.shape.db.laravel.model.Post>>,
                    response: Response<com.shackleton.shape.db.laravel.request.response.GeneralListResponse<com.shackleton.shape.db.laravel.model.Post>>,
                ) {
                    if (response.isSuccessful){
                        response.body()?.data?.let { callback(it) }
                    }else{
                        println("Response not successful: ${response.code()}")
                        callback(listOf())
                    }
                }

                override fun onFailure(call: Call<com.shackleton.shape.db.laravel.request.response.GeneralListResponse<com.shackleton.shape.db.laravel.model.Post>>, t: Throwable) {
                    println("Error: ${t.message}")
                    callback(null)
                }
            })
    }*/


}