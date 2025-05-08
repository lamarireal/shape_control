package com.shackleton.shape.db.laravel.controller

import android.content.Intent
import android.net.Uri
import androidx.fragment.app.FragmentActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PDFController {


    fun editPDFLienzoVision(view: FragmentActivity,
        project_id: Int, a : String?, b : String?,c : String?,d : String?,e : String?,
        f : String?,g : String?,h : String?,i : String?,j : String?,k : String?,l : String?,
        m : String?,n : String?,  callback: (Boolean) -> Unit){

        val pdfRequest = com.shackleton.shape.db.laravel.request.modelRequest.Modelos.PDFRequest1(
            project_id = project_id,
            a = a,
            b = b,
            c = c,
            d = d,
            e = e,
            f = f,
            h = h,
            g = g,
            i = i,
            j = j,
            k = k,
            l = l,
            m = m,
            n= n,
        )
        com.shackleton.shape.db.laravel.request.openConnection()
            .create(com.shackleton.shape.db.laravel.request.service.PDFAPI::class.java).editPDFLienzoVision(
                com.shackleton.shape.db.laravel.request.getAuthHeader(),
            pdfRequest
        ).enqueue(object : Callback<com.shackleton.shape.db.laravel.request.response.GeneralResponse>{
            override fun onResponse(call: Call<com.shackleton.shape.db.laravel.request.response.GeneralResponse>, response: Response<com.shackleton.shape.db.laravel.request.response.GeneralResponse>) {
                if (response.isSuccessful){
                    println("PDF Editado")
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(response.body()!!.data)
                    view.startActivity(intent)
                    callback(true)

                }else{
                    callback(false)
                    println(response.code())
                    println(response.message())
                }
            }
            override fun onFailure(call: Call<com.shackleton.shape.db.laravel.request.response.GeneralResponse>, t: Throwable) {
                println(t.message)

                callback(false)
            }
        })
    }
    fun editPDFLienzoModelo(view: FragmentActivity,
        project_id: Int, a : String?, b : String?,c : String?,d : String?,e : String?,
        f : String?,g : String?,h : String?,i : String?,j : String?,k : String?,l : String?,
        m : String?,n : String?,  callback: (Boolean) -> Unit){

        val pdfRequest = com.shackleton.shape.db.laravel.request.modelRequest.Modelos.PDFRequest1(
            project_id = project_id,
            a = a,
            b = b,
            c = c,
            d = d,
            e = e,
            f = f,
            h = h,
            g = g,
            i = i,
            j = j,
            k = k,
            l = l,
            m = m,
            n= n,
        )
        com.shackleton.shape.db.laravel.request.openConnection()
            .create(com.shackleton.shape.db.laravel.request.service.PDFAPI::class.java).editPDFLienzoModelo(
                com.shackleton.shape.db.laravel.request.getAuthHeader(),
            pdfRequest
        ).enqueue(object : Callback<com.shackleton.shape.db.laravel.request.response.GeneralResponse>{
            override fun onResponse(call: Call<com.shackleton.shape.db.laravel.request.response.GeneralResponse>, response: Response<com.shackleton.shape.db.laravel.request.response.GeneralResponse>) {
                if (response.isSuccessful){
                    println("PDF Editado")
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(response.body()!!.data)
                    view.startActivity(intent)
                    callback(true)

                }else{
                    callback(false)
                    println(response.code())
                    println(response.message())
                }
            }
            override fun onFailure(call: Call<com.shackleton.shape.db.laravel.request.response.GeneralResponse>, t: Throwable) {
                println(t.message)

                callback(false)
            }
        })
    }
    fun editPDFLienzoPropuesta(view: FragmentActivity,
        project_id: Int, a : String?, b : String?,c : String?,d : String?,e : String?,
        f : String?,g : String?,h : String?,i : String?,j : String?,k : String?,l : String?,
        m : String?,n : String?,  callback: (Boolean) -> Unit){

        val pdfRequest = com.shackleton.shape.db.laravel.request.modelRequest.Modelos.PDFRequest1(
            project_id = project_id,
            a = a,
            b = b,
            c = c,
            d = d,
            e = e,
            f = f,
            h = h,
            g = g,
            i = i,
            j = j,
            k = k,
            l = l,
            m = m,
            n= n,
        )

        //Adición reciente.
        val gson = com.google.gson.Gson()
        println("📊 JSON enviado: " + gson.toJson(pdfRequest))


        com.shackleton.shape.db.laravel.request.openConnection()
            .create(com.shackleton.shape.db.laravel.request.service.PDFAPI::class.java).editPDFLienzoPropuestas(
                com.shackleton.shape.db.laravel.request.getAuthHeader(),
            pdfRequest
        ).enqueue(object : Callback<com.shackleton.shape.db.laravel.request.response.GeneralResponse>{
            override fun onResponse(call: Call<com.shackleton.shape.db.laravel.request.response.GeneralResponse>, response: Response<com.shackleton.shape.db.laravel.request.response.GeneralResponse>) {
                if (response.isSuccessful){
                    println("PDF Editado")
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(response.body()!!.data)
                    view.startActivity(intent)
                    callback(true)

                }else{
                    callback(false)
                    println(response.code())
                    println(response.message())
                }
            }
            override fun onFailure(call: Call<com.shackleton.shape.db.laravel.request.response.GeneralResponse>, t: Throwable) {
                println(t.message)

                callback(false)
            }
        })
    }
    fun editPDFLienzoLeanProject(view: FragmentActivity,
        project_id: Int, a : String?, b : String?,c : String?,d : String?,e : String?,
        f : String?,g : String?,h : String?,i : String?,j : String?,k : String?,l : String?,
        m : String?,n : String?,  callback: (Boolean) -> Unit){

        val pdfRequest = com.shackleton.shape.db.laravel.request.modelRequest.Modelos.PDFRequest1(
            project_id = project_id,
            a = a,
            b = b,
            c = c,
            d = d,
            e = e,
            f = f,
            h = h,
            g = g,
            i = i,
            j = j,
            k = k,
            l = l,
            m = m,
            n= n,
        )
        com.shackleton.shape.db.laravel.request.openConnection()
            .create(com.shackleton.shape.db.laravel.request.service.PDFAPI::class.java).editPDFLienzoLeanProject(
                com.shackleton.shape.db.laravel.request.getAuthHeader(),
            pdfRequest
        ).enqueue(object : Callback<com.shackleton.shape.db.laravel.request.response.GeneralResponse>{
            override fun onResponse(call: Call<com.shackleton.shape.db.laravel.request.response.GeneralResponse>, response: Response<com.shackleton.shape.db.laravel.request.response.GeneralResponse>) {
                if (response.isSuccessful){
                    println("PDF Editado")
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(response.body()!!.data)
                    view.startActivity(intent)
                    callback(true)

                }else{
                    callback(false)
                    println(response.code())
                    println(response.message())
                }
            }
            override fun onFailure(call: Call<com.shackleton.shape.db.laravel.request.response.GeneralResponse>, t: Throwable) {
                println(t.message)

                callback(false)
            }
        })
    }
    fun editPDFLienzoValidacion(view: FragmentActivity,
        project_id: Int, a : String?, b : String?,c : String?,d : String?,e : String?,
        f : String?,g : String?,h : String?,i : String?,j : String?,k : String?,l : String?,
        m : String?,n : String?,  callback: (Boolean) -> Unit){

        val pdfRequest = com.shackleton.shape.db.laravel.request.modelRequest.Modelos.PDFRequest1(
            project_id = project_id,
            a = a,
            b = b,
            c = c,
            d = d,
            e = e,
            f = f,
            h = h,
            g = g,
            i = i,
            j = j,
            k = k,
            l = l,
            m = m,
            n= n
        )

        //Adicion reciente.
      //  println("📊 Datos de pdfRequest: $pdfRequest")
// Adición reciente: Imprimir datos antes de enviar la solicitud

        val gson = com.google.gson.Gson()
        println("📊 JSON enviado: " + gson.toJson(pdfRequest))



        com.shackleton.shape.db.laravel.request.openConnection()
            .create(com.shackleton.shape.db.laravel.request.service.PDFAPI::class.java).editPDFLienzoValidacion(
                com.shackleton.shape.db.laravel.request.getAuthHeader(),
            pdfRequest
        ).enqueue(object : Callback<com.shackleton.shape.db.laravel.request.response.GeneralResponse>{
            override fun onResponse(call: Call<com.shackleton.shape.db.laravel.request.response.GeneralResponse>, response: Response<com.shackleton.shape.db.laravel.request.response.GeneralResponse>) {
                if (response.isSuccessful){
                    println("PDF Editado")
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(response.body()!!.data)
                    view.startActivity(intent)
                    callback(true)

                }else{

                    callback(false)
                    println("❌ Error en la respuesta del servidor")
                    println("respuesta del error: "+response.code())
                    println("mensaje del error: "+response.message())


                    // Intenta imprimir el cuerpo de la respuesta (si lo tiene)
                    val errorBody = response.errorBody()?.string()
                    println("Cuerpo del error: $errorBody")

                }
            }

            override fun onFailure(call: Call<com.shackleton.shape.db.laravel.request.response.GeneralResponse>, t: Throwable) {
                println(t.message)

                callback(false)

            }
        })
    }

}