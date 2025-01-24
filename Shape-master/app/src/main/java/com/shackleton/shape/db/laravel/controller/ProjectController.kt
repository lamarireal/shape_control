package com.shackleton.shape.db.laravel.controller

import com.shackleton.shape.db.laravel.model.Proyecto
import com.shackleton.shape.db.laravel.request.getAuthHeader
import com.shackleton.shape.db.laravel.request.openConnection
import com.shackleton.shape.db.laravel.request.service.ProjectAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProjectController {
    fun getProjects( callback: (List<Proyecto>) -> Unit){
        openConnection()
            .create(ProjectAPI::class.java).getProjects(
                getAuthHeader()
            )
            .enqueue(object : Callback<List<Proyecto>>{
                override fun onResponse(
                    call: Call<List<Proyecto>>,
                    response: Response<List<Proyecto>>
                ) {
                    if (response.isSuccessful){
                        val lista = response.body()
                        callback(lista!!)
                        println("bien prj")
                    }else{
                        callback(listOf())
                        println(response.code())
                        println(response.message())
                    }
                }

                override fun onFailure(call: Call<List<Proyecto>>, t: Throwable) {
                    callback(listOf())
                    println("Error: ${t.message}")
                }
            })
    }
}