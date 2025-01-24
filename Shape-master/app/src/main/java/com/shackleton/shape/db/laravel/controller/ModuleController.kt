package com.shackleton.shape.db.laravel.controller

import com.shackleton.shape.db.laravel.model.Module
import com.shackleton.shape.db.laravel.request.getAuthHeader
import com.shackleton.shape.db.laravel.request.openConnection
import com.shackleton.shape.db.laravel.request.response.GeneralListResponse
import com.shackleton.shape.db.laravel.request.service.ModuleAPI
import com.shackleton.shape.shared.SharedApp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ModuleController {

    fun getSelectedModules(callback: (List<Module>?) -> Unit) {

        openConnection()
            .create(ModuleAPI::class.java).showSelected(
                getAuthHeader(),
            SharedApp.preferences.user.id
        ).enqueue(object : Callback<GeneralListResponse<Module>> {
            override fun onResponse(
                call: Call<GeneralListResponse<Module>>,
                response: Response<GeneralListResponse<Module>>
            )    {
                if (response.isSuccessful) {
                    val modules = response.body()?.data
                    callback(modules)
                } else {
                    println("Response not successful: ${response.code()}")
                     callback(null)
                }
            }

            override fun onFailure(call: Call<GeneralListResponse<Module>>, t: Throwable) {
                println("Error: ${t.message}")
                callback(null)
            }
        })
    }

    fun getAllModules(callback: (List<Module>?) -> Unit) {
        openConnection()
            .create(ModuleAPI::class.java).getModuleList(
                getAuthHeader()
        ).enqueue(object : Callback<GeneralListResponse<Module>> {
            override fun onResponse(
                call: Call<GeneralListResponse<Module>>,
                response: Response<GeneralListResponse<Module>>
            ) {
                if (response.isSuccessful) {
                    val modules = response.body()?.data
                    callback(modules)
                } else {
                    println("Response not successful: ${response.code()}")
                    callback(null)
                }
            }

            override fun onFailure(call: Call<GeneralListResponse<Module>>, t: Throwable) {
                println("Error: ${t.message}")
                callback(null)
            }
        })
    }

}